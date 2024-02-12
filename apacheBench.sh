#!/bin/bash

total_requests=$1
total_concorrencia=$2

base_url="http://localhost:9999/clientes/"

# random_number=$(( (RANDOM % 5) + 1 ))
# ab -n $total_requests -c $total_concorrencia "${base_url}${random_number}/extrato"

for ((i=1; i<=$total_requests; i++)); do
    random_number=$(( (RANDOM % 5) + 1 ))
    echo "Chamando URL: ${base_url}${random_number}/extrato"
    ab -n 1 "${base_url}${random_number}/extrato"
done
