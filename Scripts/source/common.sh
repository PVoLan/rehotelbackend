SCRIPT_NAME=$1


boldEcho () {
    echo "##### $1"
}


nlBoldEcho () {
    echo ""
    boldEcho "$1"
}


pressYToContinue () {
    echo ""
    read -n1 -s -r -p $'Press Y to continue...\n' key

    if [ "$key" != 'y' ]; then
        boldEcho "$SCRIPT_NAME aborted"
        exit
    fi

}


initMessage() {
    echo ''
    boldEcho "$SCRIPT_NAME started"
}


endMessage() {
    echo ''
    boldEcho "$SCRIPT_NAME finished"
}

