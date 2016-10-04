#include "cmd_backward_handler.h"

QString CmdBackwardHandler::cmd(){
	return "backward";
}

void CmdBackwardHandler::handle(QWebSocket *pClient, IWebSocketServer *pWebSocketServer, QJsonObject obj){
	/*QJsonObject jsonData;
	jsonData["cmd"] = QJsonValue(cmd());
	jsonData["connectedusers"] = pWebSocketServer->getConnectedUsers();
	pWebSocketServer->sendMessage(pClient, jsonData);*/
}
