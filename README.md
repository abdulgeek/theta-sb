# Setup Database #

1. Run mariadb on docker

    run this script in your project location
      ```
      docker run --rm \
      --name theta-db \
      -e MARIADB_DATABASE=theta \
      -e MARIADB_USER=theta \
      -e MARIADB_PASSWORD=1xylixmaF7b7rTYqqQ2Q \
      -e MARIADB_ROOT_PASSWORD=1xylixmaF7b7rTYqqQ2Q \
      -v "$PWD/thetadb-data:/var/lib/mysql" \
      -p 127.0.0.1:3306:3306 \
      mariadb:10
      ```