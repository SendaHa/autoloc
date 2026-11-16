const fs = require("fs");
const path = require("path");
const { Document, Packer, Paragraph, TextRun, ImageRun, HeadingLevel, PageBreak } = require("docx");
const sharp = require("sharp");

const root = path.resolve(__dirname, "..");
const controllerDirectory = path.join(root, "src", "main", "java", "tn", "esprit", "autolocc", "Controller");
const outputDirectory = path.join(__dirname, "captures-controllers");
const outputFile = path.join(__dirname, "AutoLoc-Controllers-et-Tests-CRUD.docx");

fs.mkdirSync(outputDirectory, { recursive: true });

function escapeXml(value) {
    return value.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
}

async function codeCapture(fileName) {
    const code = fs.readFileSync(path.join(controllerDirectory, fileName), "utf8").replace(/\r/g, "");
    const lines = code.split("\n");
    const lineHeight = 28;
    const height = Math.max(240, (lines.length + 3) * lineHeight);
    const content = lines.map((line, index) =>
        `<text x="90" y="${70 + index * lineHeight}" font-family="Consolas, monospace" font-size="20" fill="#18212b"><tspan fill="#8795a1">${String(index + 1).padStart(2, " ")}</tspan><tspan dx="28">${escapeXml(line)}</tspan></text>`
    ).join("");
    const svg = `<svg xmlns="http://www.w3.org/2000/svg" width="1800" height="${height}"><rect width="100%" height="100%" fill="#f7f9fb"/><rect width="100%" height="42" fill="#1f2937"/><circle cx="30" cy="21" r="8" fill="#ef4444"/><circle cx="56" cy="21" r="8" fill="#f59e0b"/><circle cx="82" cy="21" r="8" fill="#22c55e"/>${content}</svg>`;
    const imagePath = path.join(outputDirectory, `${path.parse(fileName).name}.png`);
    await sharp(Buffer.from(svg)).png().toFile(imagePath);
    return fs.readFileSync(imagePath);
}

async function generate() {
    const controllerFiles = fs.readdirSync(controllerDirectory).filter((file) => file.endsWith("Controller.java")).sort();
    const children = [
        new Paragraph({ text: "AutoLoc - Couche Presentation", heading: HeadingLevel.TITLE }),
        new Paragraph({ text: "Captures du code des Controllers REST" }),
        new Paragraph({ children: [new TextRun({ text: "Date : ", bold: true }), new TextRun(new Date().toLocaleDateString("fr-FR"))] }),
        new Paragraph({ text: "Chaque controller utilise son interface Service et expose POST, GET, PUT et DELETE sous /api/.", spacing: { after: 280 } })
    ];

    for (const fileName of controllerFiles) {
        const image = await codeCapture(fileName);
        children.push(new Paragraph({ text: path.parse(fileName).name, heading: HeadingLevel.HEADING_1 }));
        children.push(new Paragraph({ children: [new ImageRun({ data: image, transformation: { width: 650, height: 180 } })] }));
    }

    children.push(new Paragraph({ children: [new PageBreak()] }));
    children.push(new Paragraph({ text: "Tests CRUD avec Postman", heading: HeadingLevel.HEADING_1 }));
    children.push(new Paragraph({ text: "Etat au moment de la generation : les tests Postman ne sont pas executables, car MySQL n'est pas accessible sur localhost:3306 (Connection refused). Les captures de resultats Postman ne sont donc pas incluses afin de ne pas presenter de resultats non executes." }));
    children.push(new Paragraph({ text: "Une fois MySQL demarre et la base autolocc creee, tester chaque route avec POST /api/{ressource}, GET /api/{ressource}, GET /api/{ressource}/{id}, PUT /api/{ressource}/{id}, puis DELETE /api/{ressource}/{id}." }));

    const document = new Document({ sections: [{ properties: {}, children }] });
    fs.writeFileSync(outputFile, await Packer.toBuffer(document));
    console.log(outputFile);
}

generate().catch((error) => {
    console.error(error);
    process.exitCode = 1;
});