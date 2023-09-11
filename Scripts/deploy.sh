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
echo '##### Running SSH...'
ssh ssh.pvolan.ru 'bash -s' < deploy_remote.sh
echo '##### SSH done'


echo ''
echo '##### Deploy script completed'

