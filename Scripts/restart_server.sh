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



echo ''
echo '##### Running SSH: stop server'
ssh ssh.pvolan.ru 'bash -s' < remote/stop_server.sh
echo '##### SSH done: stop server'

pressYToContinue

echo ''
echo '##### Running SSH: start server'
ssh ssh.pvolan.ru 'bash -s' < remote/start_server.sh
echo '##### SSH done: start server'

pressYToContinue

echo ''
echo '##### Deploy script completed'

