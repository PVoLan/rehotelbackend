source source/common.sh 'Restart script'

initMessage 

nlBoldEcho 'Running SSH: stop server'
ssh ssh.pvolan.ru 'bash -s' < remote/stop_server.sh
boldEcho 'SSH done: stop server'

pressYToContinue

nlBoldEcho 'Running SSH: start server'
ssh ssh.pvolan.ru 'bash -s' < remote/start_server.sh
boldEcho 'SSH done: start server'

pressYToContinue
endMessage
