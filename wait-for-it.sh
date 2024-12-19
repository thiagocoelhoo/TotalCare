#!/bin/sh

# wait-for-it.sh
# Use this script to test if a given TCP host/port are available

set -e

host="$1"
shift
port="$1"
shift

until nc -z "$host" "$port"; do
  >&2 echo "Aguardando o MySQL estar pronto..."
  sleep 1
done

>&2 echo "MySQL está pronto - executando comando"
exec "$@"