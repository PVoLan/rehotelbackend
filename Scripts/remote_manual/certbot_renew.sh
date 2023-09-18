
echo "Updating certificate"
sudo certbot renew --force-renewal --cert-name rehotel.pvolan.ru
echo "Certificate updated"

echo "Apache reload"
service apache2 reload
echo "Apache reloaded"

