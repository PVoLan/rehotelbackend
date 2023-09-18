
SERVER_COMMAND="java -jar -Dspring.profiles.active=prod rehotel.jar"

boldEcho () {
    echo "--- $1"
}


nlBoldEcho () {
    echo ""
    boldEcho "$1"
}



start() {
    echo ''
    boldEcho "SSH started"

    nlBoldEcho 'Going to rehotel folder'
    cd rehotel
    boldEcho 'Done: in rehotel folder'
}


finish() {
    echo ''
    boldEcho "SSH finished"
}





# Keep end of line at the end of this file!

