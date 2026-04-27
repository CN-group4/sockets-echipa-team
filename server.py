import socket

IP = "0.0.0.0"   # listen on all interfaces
PORT = 5000

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.bind((IP, PORT))

print("UDP server listening on port", PORT)

while True:
    data, addr = sock.recvfrom(1024)
    message = data.decode("utf-8")

    print(f"Client {addr}: {message}")

    response = f"Echo: {message}"
    sock.sendto(response.encode("utf-8"), addr)