Add-Type -AssemblyName System.Drawing

$root = Split-Path -Parent $PSScriptRoot
$controllers = Join-Path $root "src\main\java\tn\esprit\autolocc\Controller"
$captures = Join-Path $PSScriptRoot "captures-controllers"
$report = Join-Path $PSScriptRoot "AutoLoc-Controllers-et-Tests-CRUD.doc"
New-Item -ItemType Directory -Force -Path $captures | Out-Null

function New-Capture($source) {
    $lines = Get-Content $source
    $font = New-Object System.Drawing.Font("Consolas", 10)
    $image = New-Object System.Drawing.Bitmap(1500, [Math]::Max(180, (($lines.Count + 3) * 20)))
    $draw = [System.Drawing.Graphics]::FromImage($image)
    $draw.Clear([System.Drawing.Color]::FromArgb(247, 249, 251))
    $gutter = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(235, 238, 242))
    $muted = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(123, 136, 148))
    $text = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(24, 33, 43))
    $draw.FillRectangle($gutter, 0, 0, 72, $image.Height)
    for ($line = 0; $line -lt $lines.Count; $line++) {
        $y = 22 + ($line * 20)
        $draw.DrawString(($line + 1).ToString(), $font, $muted, 20, $y)
        $draw.DrawString($lines[$line], $font, $text, 88, $y)
    }
    $file = Join-Path $captures ([IO.Path]::GetFileNameWithoutExtension($source) + ".png")
    $image.Save($file, [System.Drawing.Imaging.ImageFormat]::Png)
    $draw.Dispose(); $image.Dispose(); $font.Dispose()
    return $file
}

$content = "<h1>AutoLoc - Couche Presentation</h1><p>Captures du code des Controllers REST.</p>"
Get-ChildItem $controllers -Filter "*Controller.java" | Sort-Object Name | ForEach-Object {
    $capture = New-Capture $_.FullName
    $encoded = [Convert]::ToBase64String([IO.File]::ReadAllBytes($capture))
    $content += "<h2>$($_.BaseName)</h2><img src='data:image/png;base64,$encoded' />"
}
$content += "<div class='break'></div><h1>Tests CRUD avec Postman</h1><p><b>Etat :</b> les captures Postman ne sont pas disponibles car MySQL refuse la connexion sur localhost:3306. Il faut demarrer MySQL, puis lancer l'application sur le port 8086 pour executer POST, GET, PUT et DELETE.</p>"
$html = "<html><head><meta charset='utf-8'><style>body{font-family:Calibri;margin:2cm}h1{color:#17365d}h2{color:#28527a;margin-top:28px}img{width:17cm;max-width:100%;border:1px solid #cad3dc}.break{page-break-before:always}</style></head><body>$content</body></html>"
[IO.File]::WriteAllText($report, $html, [Text.UTF8Encoding]::new($false))
Write-Output "Rapport cree : $report"