#!/bin/bash

make clean
make build

no_tests=98

mkdir ref
rm -rf log.txt
touch fisier

grade=0
for i in {0..98}; do
	make run ARGS="input/Test$i.in ref/Test$i.out"
	java -jar checker.jar "input/Test$i.in" "ref/Test$i.out" >> log.txt
done

echo "Teste picate:"
grep 'false' fisier

echo "Total: $(grep 'true' log.txt | wc -l) / 99"

echo "Log:"
cat log.txt

echo "Total: $(grep 'true' log.txt | wc -l) / 99"

make clean
