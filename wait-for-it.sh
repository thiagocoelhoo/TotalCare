# Espera até o serviço do MySQL estar pronto para aceitar conexões
until nc -z -v -w30 $1 $2
do
  echo "Aguardando o MySQL estar pronto..."
  sleep 1
done

echo "$1:$2 está pronto para aceitar conexões!"
exec "$@"
