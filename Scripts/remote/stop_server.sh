#common.sh is imported using some magic in source/common.sh
start


######################################

nlBoldEcho 'Checking existing process'
ps aux | grep "$SERVER_COMMAND"
boldEcho 'Done: checked existing process'


nlBoldEcho 'Retreiving existing PID'
OLD_PID=`pgrep -f "$SERVER_COMMAND"`
boldEcho "Done: Received PID $OLD_PID"

if [ ! -z "$OLD_PID" ]; then
    nlBoldEcho 'Killing server process'
    kill -15 $OLD_PID
    sleep 5
    boldEcho 'Kill signal sent'
else
    nlBoldEcho 'No server process to kill'
fi


nlBoldEcho 'Retreiving existing PID again'
OLD_PID2=`pgrep -f "$SERVER_COMMAND"`
boldEcho "Done: Received PID $OLD_PID2"

if [ ! -z "$OLD_PID2" ]; then
    nlBoldEcho 'Server process is still alive, please abort'
    exit
else
    nlBoldEcho 'No server process found, good to go'
fi

##############################

finish
