source source/common.sh 'Deploy script'
initMessage 

APP_DIR='../ReHotelBackendApp'


nlBoldEcho 'Building...'
$APP_DIR/gradlew -p $APP_DIR clean assemble
boldEcho 'Build done'

pressYToContinue

nlBoldEcho 'Uploading...'
scp $APP_DIR/build/libs/rehotelfull.jar ssh.pvolan.ru:rehotel/rehotelnew.jar
boldEcho 'Upload done'

pressYToContinue

nlBoldEcho 'Running SSH: stop server'
ssh ssh.pvolan.ru 'bash -s' < remote/stop_server.sh
boldEcho 'SSH done: stop server'

pressYToContinue

nlBoldEcho 'Running SSH: update server jar'
ssh ssh.pvolan.ru 'bash -s' < remote/update_server_jar.sh
boldEcho 'SSH done: update server jar'

pressYToContinue

nlBoldEcho 'Running SSH: start server'
ssh ssh.pvolan.ru 'bash -s' < remote/start_server.sh
boldEcho 'SSH done: start server'

pressYToContinue

endMessage

