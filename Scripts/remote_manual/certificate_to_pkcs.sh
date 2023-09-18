
echo "Exporting certificate"
sudo openssl pkcs12 -export -in /etc/letsencrypt/live/rehotel.pvolan.ru/fullchain.pem -inkey /etc/letsencrypt/live/rehotel.pvolan.ru/privkey.pem -out keystore.p12 -name rehotel -CAfile /etc/letsencrypt/live/rehotel.pvolan.ru/chain.pem -caname root -password pass:dokndokn
echo "Certificate exported"


echo "Chown"
sudo chown pvolan keystore.p12
echo "Chown done"



