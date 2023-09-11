SERVER_COMMAND="java -jar -Dspring.profiles.active=prod demospring.jar"

echo ''
echo '---- SSH script started'


echo ''
echo '---- Going to demospring folder'
cd demospring
echo '---- Done: in demospring folder'


echo ''
echo '---- Checking existing process'
ps aux | grep "$SERVER_COMMAND"
echo '---- Done: checked existing process'


echo ''
echo '---- Retreiving existing PID'
OLD_PID=`pgrep -f "$SERVER_COMMAND"`
echo "---- Done: Received PID $OLD_PID"

if [ ! -z "$OLD_PID" ]; then
    echo ''
    echo '---- Killing server process'
    kill -15 $OLD_PID
    sleep 5
    echo '---- Kill signal sent'
else
    echo ''
    echo '---- No server process to kill'
fi


echo ''
echo '---- Retreiving existing PID again'
OLD_PID2=`pgrep -f "$SERVER_COMMAND"`
echo "---- Done: Received PID $OLD_PID2"
if [ ! -z "$OLD_PID2" ]; then
    echo ''
    echo '---- Server process is still alive, aborting'
    exit
else
    echo ''
    echo '---- No server process found'
fi


echo ''
echo '---- Files manipulation: removing old jar'
rm demospring.jar
echo '---- Files manipulation: Moving new jar'
mv demospringnew.jar demospring.jar
echo '---- Done: files manipulation'


echo ''
echo '---- Running server back'
eval "$SERVER_COMMAND"
echo '---- Server is up'



echo ''
echo '---- SSH script completed'
