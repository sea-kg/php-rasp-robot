#ifndef INTERFACES_ICMDHANDLER_H
#define INTERFACES_ICMDHANDLER_H

#include <QString>
#include <QJsonObject>
#include "iwebsocketserver.h"

class ICmdHandler {
	public:
		virtual QString cmd() = 0;
		virtual void handle(QWebSocket *pClient, IWebSocketServer *pWebSocketServer, QJsonObject obj) = 0;
};

#endif // INTERFACES_ICMDHANDLER_H
