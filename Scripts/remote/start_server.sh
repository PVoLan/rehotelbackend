#common.sh is imported using some magic in source/common.sh
start

####################################

nlBoldEcho 'Running server back'
eval "$SERVER_COMMAND"
boldEcho 'Server is up'

####################################

finish
