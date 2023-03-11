@echo off
setlocal enabledelayedexpansion

set "WIDTH=800"
set "HEIGHT=600"

for %%f in (*.jpg *.png *.gif) do (
  set "FILE_NAME=%%~nf_resized%%~xf"
  set "NEW_FILE_NAME=%%~nf%%~xf"
  set "BIG_FILE_NAME=big_%%~nf%%~xf"
  
  echo Resizing "%%f" to !WIDTH!x!HEIGHT! pixels...
  powershell -Command "Add-Type -AssemblyName System.Drawing; $img = [System.Drawing.Image]::FromFile('%%f'); $thumb = $img.GetThumbnailImage(!WIDTH!, !HEIGHT!, $null, [System.IntPtr]::Zero); $thumb.Save('!FILE_NAME!')"
  
  echo Renaming "!FILE_NAME!" to "!NEW_FILE_NAME!"...
  ren "!FILE_NAME!" "!NEW_FILE_NAME!"
  
  echo Renaming "%%f" to "!BIG_FILE_NAME!"...
  ren "%%f" "!BIG_FILE_NAME!"
)

echo All images resized and renamed.
pause
