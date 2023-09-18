source source/common.sh 'Restart script'

initMessage 

nlBoldEcho 'Running SSH: stop server'
sshRunScript remote/stop_server.sh
boldEcho 'SSH done: stop server'

pressYToContinue

nlBoldEcho 'Running SSH: start server'
sshRunScript remote/start_server.sh
boldEcho 'SSH done: start server'

pressYToContinue
endMessage
