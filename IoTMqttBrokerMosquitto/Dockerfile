FROM eclipse-mosquitto
COPY config/mosquitto.conf /mosquitto/config/mosquitto.conf
ENTRYPOINT ["mosquitto", "-c", "/mosquitto/config/mosquitto.conf", "-v"]