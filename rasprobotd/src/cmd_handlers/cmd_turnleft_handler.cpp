#include "cmd_turnleft_handler.h"

QString CmdTurnleftHandler::cmd(){
	return "turnleft";
}

void CmdTurnleftHandler::handle(QWebSocket *pClient, IWebSocketServer *pWebSocketServer, QJsonObject obj){
	/*QJsonObject jsonData;
	jsonData["cmd"] = QJsonValue(cmd());
	jsonData["connectedusers"] = pWebSocketServer->getConnectedUsers();
	pWebSocketServer->sendMessage(pClient, jsonData);*/
}
