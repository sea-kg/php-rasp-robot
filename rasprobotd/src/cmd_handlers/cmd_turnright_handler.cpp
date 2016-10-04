#include "cmd_turnright_handler.h"

QString CmdTurnrightHandler::cmd(){
	return "turnright";
}

void CmdTurnrightHandler::handle(QWebSocket *pClient, IWebSocketServer *pWebSocketServer, QJsonObject obj){
	/*QJsonObject jsonData;
	jsonData["cmd"] = QJsonValue(cmd());
	jsonData["connectedusers"] = pWebSocketServer->getConnectedUsers();
	pWebSocketServer->sendMessage(pClient, jsonData);*/
}
