if [ $# -ne 3 ]; then
    echo "usage: user pass nombre"
    exit 1
fi

user="$1"
pass="$2"
nombre="$3"

server="http://localhost:8080"
auth="X-Authorization: $user:$pass"
content_type="Content-Type: application/x-www-form-urlencoded"
accept="Accept: application/json"

data="{ \"nombre\":\"$nombre\", \"lat\":\"1.0\", \"lng\":\"1.0\" }"

#curl -X POST -H "$auth" -H "$content_type" --data "$data" "$server/localidad"
curl -H "$auth" -H "$content_type" -H "$accept" -d "nombre=$nombre&lng=1.0&lat=1.0" "$server/form_localidad"
echo


