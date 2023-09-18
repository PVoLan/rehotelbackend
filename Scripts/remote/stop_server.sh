SERVER_COMMAND="java -jar -Dspring.profiles.active=prod rehotel.jar"

echo ''
echo '---- SSH script started'


echo ''
echo '---- Going to rehotel folder'
cd rehotel
echo '---- Done: in rehotel folder'


######################################

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
    echo '---- Server process is still alive, please abort'
    exit
else
    echo ''
    echo '---- No server process found, good to go'
fi

##############################

echo ''
echo '---- SSH script completed'
