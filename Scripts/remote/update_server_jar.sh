SERVER_COMMAND="java -jar -Dspring.profiles.active=prod rehotel.jar"

echo ''
echo '---- SSH script started'


echo ''
echo '---- Going to rehotel folder'
cd rehotel
echo '---- Done: in rehotel folder'

##################################


echo ''
echo '---- Files manipulation: removing old jar'
rm rehotel.jar
echo '---- Files manipulation: Moving new jar'
mv rehotelnew.jar rehotel.jar
echo '---- Done: files manipulation'

##################################

echo ''
echo '---- SSH script completed'
