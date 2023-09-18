#common.sh is imported using some magic in source/common.sh
start

##################################


nlBoldEcho 'Files manipulation: removing old jar'
rm rehotel.jar
boldEcho 'Files manipulation: Moving new jar'
mv rehotelnew.jar rehotel.jar
boldEcho 'Done: files manipulation'

##################################

finish
