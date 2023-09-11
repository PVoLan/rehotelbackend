pressYToContinue (){
    read -n1 -s -r -p $'Press Y to continue...\n' key

    if [ "$key" != 'y' ]; then
        echo '##### Deploy script aborted'
        exit
    fi

}


echo ''
echo '##### Deploy script started'
echo ''
echo '##### Building...'
./gradlew clean assemble
echo '##### Build done'

pressYToContinue

echo ''
echo '##### Uploading...'
scp ./build/libs/springdemofull.jar ssh.pvolan.ru:demospring/demospringnew.jar
echo '##### Upload done'

pressYToContinue


echo ''
echo '##### Running SSH...'
ssh ssh.pvolan.ru 'bash -s' < deploy_remote.sh
echo '##### SSH done'


echo ''
echo '##### Deploy script completed'

