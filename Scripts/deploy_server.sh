pressYToContinue (){
    read -n1 -s -r -p $'Press Y to continue...\n' key

    if [ "$key" != 'y' ]; then
        echo '##### Deploy script aborted'
        exit
    fi

}

APP_DIR='../ReHotelBackendApp'

echo ''
echo '##### Deploy script started'
echo ''
echo '##### Building...'
$APP_DIR/gradlew -p $APP_DIR clean assemble
echo '##### Build done'

pressYToContinue

echo ''
echo '##### Uploading...'
scp $APP_DIR/build/libs/rehotelfull.jar ssh.pvolan.ru:rehotel/rehotelnew.jar
echo '##### Upload done'

pressYToContinue


echo ''
echo '##### Running SSH: stop server'
ssh ssh.pvolan.ru 'bash -s' < remote/stop_server.sh
echo '##### SSH done: stop server'

pressYToContinue

echo ''
echo '##### Running SSH: update server jar'
ssh ssh.pvolan.ru 'bash -s' < remote/update_server_jar.sh
echo '##### SSH done: update server jar'

pressYToContinue
echo ''
echo '##### Running SSH: start server'
ssh ssh.pvolan.ru 'bash -s' < remote/start_server.sh
echo '##### SSH done: start server'

pressYToContinue

echo ''
echo '##### Deploy script completed'

