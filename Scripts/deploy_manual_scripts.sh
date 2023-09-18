source source/common.sh 'Deploy script'
initMessage 


nlBoldEcho 'Uploading...'
scp remote_manual/certbot_renew.sh ssh.pvolan.ru:rehotel/certbot_renew.sh
scp remote_manual/certificate_to_pkcs.sh ssh.pvolan.ru:rehotel/certificate_to_pkcs.sh
boldEcho 'Upload done'

pressYToContinue

endMessage

