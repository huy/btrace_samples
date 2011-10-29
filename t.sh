set -x
../bin/btracec $1.java
if [ $? != 0 ]; then
  exit 1
fi

java Hello 15  &
java_pid=$!
sleep 5
../bin/btrace $java_pid $1.class
wait $java_pid
