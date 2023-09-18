SERVER_COMMAND="java -jar -Dspring.profiles.active=prod rehotel.jar"

echo ''
echo '---- SSH script started'


echo ''
echo '---- Going to rehotel folder'
cd rehotel
echo '---- Done: in rehotel folder'

####################################

echo ''
echo '---- Running server back'
eval "$SERVER_COMMAND"
echo '---- Server is up'

####################################


echo ''
echo '---- SSH script completed'
