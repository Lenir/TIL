/*
 * echoServer.cpp
 *
 *  Created on: 2018. 2. 1.
 *      Author: Ciel
 */

#include "echoServer.h"

#include <iostream>
#include <string>
#include <boost/asio.hpp>

using namespace boost::asio;
using namespace std;
using namespace boost::asio::ip;

const unsigned short SERVER_PORT = 7777;


echoServer::echoServer() {
	// TODO Auto-generated constructor stub

	tcp::endpoint endpoint(tcp::v4(), SERVER_PORT);

	io_service ioService;

	tcp::acceptor acceptor(ioService);
	acceptor.open(endpoint.protocol());
	acceptor.set_option(socket_base::reuse_address(true));
	acceptor.bind(endpoint);

	acceptor.listen();

	boost::system::error_code errCode;
	tcp::socket socket(ioService);

	acceptor.accept(socket, errCode);

	if (error){
		cout << "error id : " << errCode.value() << " error message : " << errCode.message() << endl;
		return;
	}

	cout << "connected Client" << endl;

	while(true){
		boost::array<char, 128> buff;
		buff.assign(0);

		size_t len = socket.read_some(boost::asio::buffer(buff), errCode);

		if (errCode)
		{

			if (errCode == boost::asio::error::eof)
			{
				cout << errCode.message() << endl;
				cout << "disconnected client" << endl;
			}
			else
			{
				cout << "error id : " << errCode.value() << " error message : " << errCode.message() << endl;
			}
		}

		cout << "Message : " << &buff[0] << endl;

		boost::system::error_code write_error;
		std::string tempStringbuffer;
		socket.write_some(boost::asio::buffer(tempStringbuffer), write_error);
	}

}

echoServer::~echoServer() {
	// TODO Auto-generated destructor stub
}

