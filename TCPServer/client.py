import socket

SERVER_IP = "100.117.176.90" 
PORT = 5000

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

print("Type messages (type 'exit' to quit)")

while True:
    msg = input("You: ")

    if msg.lower() == "exit":
        break

    sock.sendto(msg.encode("utf-8"), (SERVER_IP, PORT))

    data, _ = sock.recvfrom(1024)
    print("Server:", data.decode("utf-8"))

sock.close()