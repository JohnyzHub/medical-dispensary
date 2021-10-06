# Azure Environment
export SUBSCRIPTION=<subscription-id>
export RESOURCE_GROUP=<resource-group-name>
export WEBAPP=medical-dispensary # preferrably artifact-id from pom.
export REGION=eastus

# ======== Database Environment Variable Values ===========
export DATABASE_SERVER=postgresql
export DATABASE_ADMIN=postgres
export DATABASE_ADMIN_PASSWORD=asdfgh


# Composed secrets for PostgreSQL
export POSTGRES_SERVER_NAME=postgresql
export POSTGRES_SERVER_ADMIN_LOGIN_NAME=postgres
export POSTGRES_SERVER_ADMIN_PASSWORD=asdfgh
export POSTGRES_DATABASE_NAME=postgres

export POSTGRES_SERVER_FULL_NAME=${POSTGRES_SERVER_NAME}.postgres.database.azure.com
export POSTGRES_CONNECTION_URL=jdbc:postgresql://${POSTGRES_SERVER_FULL_NAME}:5432/${POSTGRES_DATABASE_NAME}?ssl=true
export POSTGRES_SERVER_ADMIN_FULL_NAME=${POSTGRES_SERVER_ADMIN_LOGIN_NAME}@${POSTGRES_SERVER_NAME}

# ${project.basedir} is the root directory of your project.
# ${project.build.directory} is equivalent to ${project.basedir}/target
