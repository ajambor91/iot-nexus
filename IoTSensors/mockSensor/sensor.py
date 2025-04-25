# import time
# import paho.mqtt.client as mqtt
#
# def on_publish(client, userdata, mid, reason_code, properties):
#     # reason_code and properties will only be present in MQTTv5. It's always unset in MQTTv3
#     try:
#         userdata.remove(mid)
#     except KeyError:
#         print("Exception")
#
#
# unacked_publish = set()
# mqttc = mqtt.Client(mqtt.CallbackAPIVersion.VERSION2)
# mqttc.on_publish = on_publish
#
# mqttc.user_data_set(unacked_publish)
# mqttc.connect("localhost")
# mqttc.loop_start()
#
# # Our application produce some messages
# msg_info = mqttc.publish("test-topic", "my medfdfdfdfssage", qos=0)
# unacked_publish.add(msg_info.mid)
#
# # msg_info2 = mqttc.publish("paho/test/topic", "my message2", qos=2)
# # unacked_publish.add(msg_info2.mid)
#
# # Wait for all message to be published
# while len(unacked_publish):
#     time.sleep(0.1)
#
# # Due to race-condition described above, the following way to wait for all publish is safer
# msg_info.wait_for_publish()
# # msg_info2.wait_for_publish()
#
# mqttc.disconnect()
# mqttc.loop_stop()

# to = 2500000
# i = 0;
# j = 0;
# while (i < to):
#     j = j + 2
#     i = i + 1
#
# print(j)

import plotly.express as px
df = px.data.tips()
fig = px.histogram(df, x="day", y="total_bill", color="sex",
            title="Receipts by Payer Gender and Day of Week vs Target",
            width=600, height=400,
            labels={"sex": "Payer Gender",  "day": "Day of Week", "total_bill": "Receipts"},
            category_orders={"day": ["Thur", "Fri", "Sat", "Sun"], "sex": ["Male", "Female"]},
            color_discrete_map={"Male": "RebeccaPurple", "Female": "MediumPurple"},
            template="simple_white"
            )

fig.update_yaxes( # the y-axis is in dollars
    tickprefix="$", showgrid=True
)

fig.update_layout( # customize font and legend orientation & position
    font_family="Rockwell",
    legend=dict(
        title=None, orientation="h", y=1, yanchor="bottom", x=0.5, xanchor="center"
    )
)

fig.add_shape( # add a horizontal "target" line
    type="line", line_color="salmon", line_width=3, opacity=1, line_dash="dot",
    x0=0, x1=1, xref="paper", y0=950, y1=950, yref="y"
)

fig.add_annotation( # add a text callout with arrow
    text="below target!", x="Fri", y=400, arrowhead=1, showarrow=True
)

fig.show()