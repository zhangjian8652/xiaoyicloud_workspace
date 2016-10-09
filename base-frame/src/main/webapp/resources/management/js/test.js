/**
 * Created by Administrator on 2016/4/11.
 */
var GRCaller = function () {
    var calltypes = {
        webRTCCall: "webRTCCall",
        flashCall: "flashCall"
    }, flashId = "flashPannel", grUserAgent, grSession, GRUserAgent, GRSession, CallerUtil, userAgentCallbacks, userAgentCallbacksWraper, sessionCallbacks, sessionCallbacksWraper, flashCallbacks, calltype, handlerSettings, handler, libBase, callTimer, Caller, clientUsername, clientPassword, callPrefix = "0047,0044", updateID = "", sessionID = "";
    GRUserAgent = function () {
        var e, n, a, l, s, t = function (t) {
            switch (calltype) {
                case calltypes.webRTCCall:
                    return n = {
                        level: "debug",
                        traceSip: !0,
                        register: !1
                    }, t && (t.hasOwnProperty("username") && "" != t.username && t.hasOwnProperty("password") && "" != t.password && (a = {
                        authorizationUser: t.username,
                        password: t.password
                    }), t.hasOwnProperty("serverIP") && "" != t.serverIP && t.hasOwnProperty("serverPort") && "" != t.serverPort && t.hasOwnProperty("serverRelm") && "" != t.serverRelm && (l = {
                        serverIP: t.serverIP,
                        serverPort: t.serverPort,
                        serverRelm: t.serverRelm,
                        uri: t.username + "@" + t.serverRelm,
                        ws_servers: "wss://" + t.serverIP + ":" + t.serverPort
                    })), n = $.extend(n, a || {}, l || {}), e = new SIP.UA(n), o(e), userAgentCallbacksWraper.onInit(e), e;
                case calltypes.flashCall:
                    var r = {wmode: "transparent", ScriptAccess: "always", bgcolor: "transparent"};
                    t && (t.hasOwnProperty("rtmpURL") && "" != t.rtmpURL && (l = {
                        vars: {
                            enable_debug: t.enableDebug,
                            enable_js_api: t.enableJsAPI,
                            rtmp_url: t.rtmpURL,
                            debug_ping: t.debugPing,
                            onDebug: "GRCaller.onDebug",
                            onInit: "GRCaller.getUserAgentCallbacks().onInit"
                        }
                    }), t.hasOwnProperty("username") && "" != t.username && t.hasOwnProperty("password") && "" != t.password && (a = {
                        authorizationUser: t.username,
                        password: t.password
                    })), n = $.extend(n, l || {}, a || {}), swfobject.embedSWF(libBase + "/webphone.swf", flashId, "260", "160", "9.0.0", libBase + "/expressInstall.swf", n.vars, r, {}, function () {
                        e = {
                            registerCallbackFuntions: function () {
                                $("#" + flashId)[0].registerCallbackFuntions({
                                    onTimeout: "",
                                    onConnected: "GRCaller.getUserAgentCallbacks().onConnected",
                                    onDisconnected: "GRCaller.getUserAgentCallbacks().onDisconnected",
                                    onHangup: "GRCaller.getFlashCallbacks().onHangup",
                                    onLogin: "",
                                    onLogout: "",
                                    onAttach: "",
                                    onMakeCall: "",
                                    onCallState: "GRCaller.getFlashCallbacks().onCallState",
                                    onDisplayUpdate: "",
                                    onIncomingCall: "",
                                    onEvent: ""
                                })
                            }, setConnectURL: function (e) {
                                $("#" + flashId)[0].setConnectURL(e)
                            }, isConnected: function () {
                                return console.debug("is flash connect!  flashId : " + flashId), 200 == $("#" + flashId)[0].getRtmpConnectStatus() ? !0 : !1
                            }, connect: function (e) {
                                window.console && GRCaller.onDebug("==> Connect server [" + e + "]");
                                try {
                                    $("#" + flashId)[0].setTimeout(30, "connect"), $("#" + flashId)[0].connect(e), $("#" + flashId)[0].showPrivacy()
                                } catch (n) {
                                    console.error(n)
                                }
                            }, disconnect: function () {
                                window.console && GRCaller.onDebug("==> Disonnect server"), $("#" + flashId)[0].disconnect()
                            }, isMuted: function () {
                                return $("#" + flashId)[0].isMuted()
                            }, showPrivacy: function () {
                                $("#flashPannelWraper").animate({top: 0}, 600), $("#" + flashId).css("visibility", "visible"), $("#" + flashId)[0].showPrivacy()
                            }, hidePrivacy: function () {
                                $("#flashPannelWraper").animate({top: -260}, 800)
                            }, makeCall: function (n, a, l) {
                                s = setInterval(function () {
                                    if (window.console && GRCaller.onDebug("show privacy"), e.isMuted())e.showPrivacy(); else try {
                                        $("#" + flashId)[0].setTimeout(180, "call"), void 0 != a && "" != a && (a = a + "@" + $("#" + flashId)[0].get_cur_uri()), $("#" + flashId)[0].makeCall(n, a || "", l), clearInterval(s), e.hidePrivacy()
                                    } catch (t) {
                                        GRCaller.onDebug(t)
                                    }
                                }, 1e3);
                                var t = function () {
                                    return {
                                        setUUID: function (e) {
                                            this.uuid = e
                                        }, dtmf: function (e, n) {
                                            $("#" + flashId)[0].sendDTMF(e, n)
                                        }, hangup: function (e) {
                                            $("#" + flashId)[0].hangup(e)
                                        }, answer: function (e) {
                                            $("#" + flashId)[0].answer(e)
                                        }, attach: function (e) {
                                            $("#" + flashId)[0].attach(e)
                                        }, sendDigit: function (e) {
                                            $("#" + flashId)[0].sendDTMF(e, 2e3)
                                        }, setVolume: function (e) {
                                            $("#" + flashId)[0].setVolume(e)
                                        }, setMicVolume: function (e) {
                                            $("#" + flashId)[0].setMicVolume(e)
                                        }
                                    }
                                };
                                return t()
                            }, transfer: function (e, n) {
                                $("#" + flashId)[0].transfer(e, n)
                            }, ui_transfer: function (e) {
                                $("#transfer").data("uuid", e)
                            }, three_way: function (e, n) {
                                $("#" + flashId)[0].three_way(e, n)
                            }, do_three_way: function (e) {
                                var n = $(".active_call").data("uuid");
                                "" != n && this.three_way(n, e)
                            }, join: function (e, n) {
                                $("#" + flashId)[0].join(e, n)
                            }, do_join: function (e) {
                                var n = $(".active_call").data("uuid");
                                "" != n && this.join(n, e)
                            }, login: function (e, n, a) {
                                var l = $("#" + flashId)[0].get_cur_uri();
                                user_to_login = e + "@" + l, $("#" + flashId)[0].login(user_to_login, n, a)
                            }, logout: function (e) {
                                $("#" + flashId)[0].logout(e)
                            }, getNetQuality: function () {
                                return $("#" + flashId)[0].getNetQuality()
                            }, getNetQualityDetail: function () {
                                return $("#" + flashId)[0].getNetQualityDetail()
                            }
                        }, GRCaller.onDebug("==> Load Swf Finish."), userAgentCallbacksWraper.onInit = function () {
                            window.console && GRCaller.onDebug("==> OnInit");
                            var n = $("#flashPannelWraper").offset();
                            $("#flashPannelWraper").offset({
                                left: 0,
                                top: n.top
                            }), e.connect(""), e.registerCallbackFuntions(), userAgentCallbacks.onInit()
                        }
                    })
            }
        }, o = function (e) {
            e.on("invite", function (e) {
                window.console && GRCaller.onDebug("==> receive incoming call"), e.accept(options), userAgentCallbacksWraper.onInvite()
            }), e.on("message", function (e) {
                window.console && GRCaller.onDebug("==> onMessage Callback"), userAgentCallbacksWraper.onMessage()
            }), e.on("registrationFailed", function (e) {
                window.console && console.info("==> onRegistrationFailed, cause: " + e), userAgentCallbacksWraper.onRegistrationFailed(e)
            }), e.on("unregistered", function (e) {
                window.console && console.info("==> onUnregistered, cause: " + e), userAgentCallbacksWraper.onUnregistered(e)
            }), e.on("registered", function () {
                window.console && console.info(" register success"), userAgentCallbacksWraper.onRegistered()
            }), e.on("disconnected", function (e) {
                window.console && console.info("==> Webrtc Disconnected");
                try {
                    e.bye(), e = ""
                } catch (n) {
                    window.console && console.error(n.message)
                }
                userAgentCallbacksWraper.onDisconnected(e)
            }), e.on("connected", function () {
                window.console && console.info("==> Server onConnected"), userAgentCallbacksWraper.onConnected()
            })
        }, r = function (e) {
            var n = function (e) {
                var n = "uid=" + e + "&prefix=" + callPrefix + "&updateID=" + $(handlerSettings.handler).attr("data-updateID"), a = CryptoJS.enc.Utf8.parse(n), l = CryptoJS.enc.Base64.stringify(a);
                return l
            }, a = "";
            switch (calltype) {
                case calltypes.webRTCCall:
                    a = "sip:" + n(e) + "@" + l.serverIP;
                    break;
                case calltypes.flashCall:
                    a = n(e)
            }
            return a
        };
        return {
            init: function (e) {
                switch (calltype) {
                    case calltypes.webRTCCall:
                        var n = $('<audio id="remoteAudio"></audio><audio id="localAudio"  muted="muted"></audio>');
                        $("body").append(n);
                        break;
                    case calltypes.flashCall:
                        var a = $(handlerSettings.handler);
                        if ("undefined" == typeof a[0])return alert("Do not find handler [" + handlerSettings.handler + "],check again please."), !1;
                        var l = $(handlerSettings.handler).eq(0).parent(), s = $('<div id="flashPannelWraper" style="position: fixed;top:0px;left:0px;padding:5px;z-index: 2000;"></div>'), n = $('<div class="flash-install" id="' + flashId + '" > Your browser may not have Flash installed or Flash may be disabled. Please ensure Flash enabled. If Flash is not installed,  <a href="https://get.adobe.com/flashplayer/?loc=en" > click to install</a> </div>');
                        s.append(n), l.after(s)
                }
                t(e)
            }, encryptCallhandle: function (e) {
                return r(e)
            }, generatorUserAgent: function (e) {
                t(e)
            }, toggleServer: function (n, a, l) {
                e = t({serverIP: n, serverPort: a, serverRelm: l})
            }, makecall: function (a, l) {
                var s = r(a);
                switch (calltype) {
                    case calltypes.webRTCCall:
                        window.console && GRCaller.onDebug("==> webRTC call,callnumber = " + a);
                        var t = {
                            media: {
                                constraints: {audio: !0, video: !1},
                                render: {remote: document.getElementById("remoteAudio")}
                            }
                        };
                        window.console && console.info("==> try call " + s);
                        var o = e.invite(s, t);
                        window.console && console.info("==> bind web RTC session event"), grSession.bindSessionEvent(o, l);
                        break;
                    case calltypes.flashCall:
                        window.console && (console.info("==> try call " + s), console.info("==> bind flash session event")), e.login(clientUsername, clientPassword, sessionID);
                        var o = e.makeCall(s, n.authorizationUser, []);
                        grSession.bindFlashCallbacks(o, l)
                }
            }, login: function (e, n) {
                var a = t({username: e, password: n});
                "" != e && "" != n && a.register()
            }, logout: function (n) {
                e.unregister()
            }, connect: function () {
                switch (calltype) {
                    case calltypes.webRTCCall:
                        e.start();
                        break;
                    case calltypes.flashCall:
                        e.connect("")
                }
            }, disconnect: function () {
                console.log(e), e.stop()
            }, isConnected: function () {
                return e.isConnected()
            }, showPrivacy: function () {
                e.showPrivacy && e.showPrivacy()
            }, hidePrivacy: function () {
                e.hidePrivacy && (e.hidePrivacy(), clearInterval(s))
            }
        }
    }, GRSession = function () {
        var e;
        return {
            bindFlashCallbacks: function (n, a) {
                flashCallbacks = {}, e = n, flashCallbacks.onCallState = function (n, l) {
                    try {
                        e.setUUID(n), window.console && GRCaller.onDebug("==>uuid: " + n + ", state: " + l)
                    } catch (s) {
                    }
                    switch (l) {
                        case"DOWN":
                            break;
                        case"RINGING":
                            sessionCallbacksWraper.onConnecting(a), grSession.mute();
                            break;
                        case"EARLY":
                            sessionCallbacksWraper.onProgress(l, a), grSession.mute();
                            break;
                        case"ACTIVE":
                            sessionCallbacksWraper.onAccepted(l, a), grSession.unmute();
                            break;
                        case"HANGUP":
                            sessionCallbacksWraper.onHangup(l, a), grSession.unmute(), e = null
                    }
                }, flashCallbacks.onHangup = function (e, n) {
                    try {
                        window.console && GRCaller.onDebug("hangup cause:" + n)
                    } catch (l) {
                    }
                    switch (n) {
                        case 16:
                            sessionCallbacksWraper.onHangup(n, a);
                            break;
                        case 200:
                            sessionCallbacksWraper.onHangup(n, a);
                            break;
                        case 404:
                            sessionCallbacksWraper.onFailed(n, a);
                            break;
                        case 408:
                            sessionCallbacksWraper.onFailed(n, a);
                            break;
                        case 480:
                            sessionCallbacksWraper.onFailed(n, a);
                            break;
                        case 486:
                            sessionCallbacksWraper.onFailed(n, a);
                            break;
                        case 503:
                            sessionCallbacksWraper.onFailed(n, a);
                            break;
                        case 603:
                            sessionCallbacksWraper.onFailed(n, a);
                            break;
                        case 629:
                            sessionCallbacksWraper.onFailed(n, a);
                            break;
                        case 630:
                            sessionCallbacksWraper.onFailed(n, a);
                            break;
                        case 487:
                            sessionCallbacksWraper.onFailed(n, a);
                            break;
                        default:
                            n >= 621 && 626 >= n ? sessionCallbacksWraper.onFailed(n, a) : (627 == n || 628 == n) && sessionCallbacksWraper.onFailed(n, a)
                    }
                }
            }, bindSessionEvent: function (n, a) {
                e = n, n.on("connecting", function () {
                    window.console && GRCaller.onDebug("==> session connecting"), sessionCallbacksWraper.onConnecting(a)
                }), n.on("progress", function (e) {
                    window.console && GRCaller.onDebug("==> session progress"), sessionCallbacksWraper.onProgress(e, a)
                }), n.on("accepted", function (e) {
                    window.console && GRCaller.onDebug("==> session accepted"), sessionCallbacksWraper.onAccepted(e, a)
                }), n.on("rejected", function (e, l) {
                    window.console && GRCaller.onDebug("==> session rejected");
                    try {
                        n.bye(), n = ""
                    } catch (s) {
                        window.console && console.error(s.message)
                    }
                    console.log("rejected cause : " + l), sessionCallbacksWraper.onRejected(e, l, a)
                }), n.on("failed", function (e, n) {
                    window.console && GRCaller.onDebug("==> session failed"), sessionCallbacksWraper.onFailed(e, n, a)
                }), n.on("cancel", function () {
                    window.console && GRCaller.onDebug("==> session cancel"), sessionCallbacksWraper.onCancel(a)
                }), n.on("refer", function (e) {
                    window.console && GRCaller.onDebug("==> session refer"), sessionCallbacksWraper.onRefer(e, a)
                }), n.on("dtmf", function (e, n) {
                    window.console && GRCaller.onDebug("==> session dtmf"), sessionCallbacksWraper.onDtmf(e, n, a)
                }), n.on("muted", function (e) {
                    window.console && GRCaller.onDebug("==> session muted"), sessionCallbacksWraper.onMuted(e, a)
                }), n.on("unmuted", function (e) {
                    window.console && GRCaller.onDebug("==> session unmuted"), sessionCallbacksWraper.onUnmuted(e, a)
                }), n.on("bye", function (e) {
                    window.console && GRCaller.onDebug("==> session bye"), sessionCallbacksWraper.onHangup(e, a)
                })
            }, hangup: function () {
                switch (calltype) {
                    case calltypes.webRTCCall:
                        try {
                            e.bye()
                        } catch (n) {
                            window.console && console.error(n.message);
                            try {
                                e.cancel()
                            } catch (n) {
                                window.console && console.error(n.message)
                            }
                        }
                        break;
                    case calltypes.flashCall:
                        e.hangup()
                }
            }, mute: function () {
                switch (calltype) {
                    case calltypes.webRTCCall:
                        e.mute();
                        break;
                    case calltypes.flashCall:
                        e.setMicVolume(0), sessionCallbacksWraper.onMuted(null, $(handlerSettings.handler)[0])
                }
            }, unmute: function () {
                switch (calltype) {
                    case calltypes.webRTCCall:
                        e.unmute();
                        break;
                    case calltypes.flashCall:
                        e.setMicVolume(1), sessionCallbacksWraper.onUnmuted(null, $(handlerSettings.handler)[0])
                }
            }, answer: function () {
                e.accept()
            }, sendDtmf: function (n) {
                e.dtmf(n)
            }
        }
    }, userAgentCallbacksWraper = {
        onInit: function () {
            window.console && GRCaller.onDebug("==> OnInit"), userAgentCallbacks.onInit()
        }, onInvite: function (e) {
            window.console && GRCaller.onDebug("==> receive incoming call"), e.accept(options), userAgentCallbacks.onInvite(e)
        }, onMessage: function (e) {
            window.console && GRCaller.onDebug("==> onMessage Callback"), userAgentCallbacks.onMessage(e)
        }, onRegistrationFailed: function (e) {
            window.console && console.info("==> onRegistrationFailed, cause: " + e), userAgentCallbacks.onRegistrationFailed(e)
        }, onUnregistered: function (e) {
            window.console && console.info("==> onUnregistered, cause: " + e), userAgentCallbacks.onUnregistered(e)
        }, onRegistered: function () {
            window.console && console.info(" register success"), userAgentCallbacks.onRegistered()
        }, onDisconnected: function (e) {
            window.console && console.info("==> User Agent onDisconnected");
            try {
                e.bye(), e = ""
            } catch (n) {
                window.console && console.error(n.message)
            }
            handler = handlerSettings.handler, $(handler).each(function (e) {
                CallerUtil.bindMakeCallEvent(this)
            }), userAgentCallbacks.onDisconnected(e)
        }, onConnected: function () {
            window.console && console.info("==> User Agent onConnected"), handler = handlerSettings.handler, $(handler).each(function (e) {
                CallerUtil.bindMakeCallEvent(this)
            }), userAgentCallbacks.onConnected()
        }
    }, userAgentCallbacks = {
        onInit: function () {
        }, onInvite: function (e) {
        }, onMessage: function (e) {
        }, onRegistrationFailed: function (e) {
        }, onUnregistered: function (e) {
        }, onRegistered: function () {
        }, onDisconnected: function (e) {
        }, onConnected: function () {
        }
    }, sessionCallbacksWraper = {
        onConnecting: function (e) {
            window.console && GRCaller.onDebug("==> onConnecting Callback"), CallerUtil.bindMuteEvent(), sessionCallbacks.onConnecting(e)
        }, onProgress: function (e, n) {
            window.console && GRCaller.onDebug("==> onProgress Callback"), sessionCallbacks.onProgress(e, n)
        }, onAccepted: function (e, n) {
            window.console && GRCaller.onDebug("==> onAccepted Callback"), CallerUtil.bindEndCallEvent(n), sessionCallbacks.onAccepted(e, n)
        }, onCancel: function (e) {
            window.console && GRCaller.onDebug("==> onCancel Callback"), CallerUtil.bindMakeCallEvent(e), CallerUtil.unbindMuteEvent(), sessionCallbacks.onCancel(e)
        }, onHangup: function (e, n) {
            window.console && GRCaller.onDebug("==> onHangup Callback"), CallerUtil.bindMakeCallEvent(n), CallerUtil.unbindMuteEvent(), sessionCallbacks.onHangup(e, n)
        }, onRejected: function (e, n, a) {
            window.console && GRCaller.onDebug("==> onRejected Callback"), CallerUtil.bindMakeCallEvent(a), CallerUtil.unbindMuteEvent(), sessionCallbacks.onRejected(e, n, a)
        }, onFailed: function (e, n, a) {
            window.console && GRCaller.onDebug("==> onFailed Callback"), CallerUtil.bindMakeCallEvent(a), CallerUtil.unbindMuteEvent(), sessionCallbacks.onFailed(e, n, a)
        }, onRefer: function (e, n) {
            window.console && GRCaller.onDebug("==> onRefer Callback"), sessionCallbacks.onRefer(e, n)
        }, onDtmf: function (e, n, a) {
            window.console && GRCaller.onDebug("==> onDtmf Callback"), sessionCallbacks.onDtmf(e, n, a)
        }, onMuted: function (e, n) {
            window.console && GRCaller.onDebug("==> onMuted Callback"), sessionCallbacks.onMuted(e, n)
        }, onUnmuted: function (e, n) {
            window.console && GRCaller.onDebug("==> onUnmuted Callback"), sessionCallbacks.onUnmuted(e, n)
        }
    }, sessionCallbacks = {
        onConnecting: function (e) {
        }, onProgress: function (e, n) {
        }, onAccepted: function (e, n) {
        }, onCancel: function (e) {
        }, onHangup: function (e, n) {
        }, onRejected: function (e, n, a) {
        }, onFailed: function (e, n, a) {
        }, onRefer: function (e, n) {
        }, onDtmf: function (e, n, a) {
        }, onMuted: function (e, n) {
        }, onUnmuted: function (e, n) {
        }
    }, CallerUtil = {
        init: function (e, n) {
            grUserAgent = GRUserAgent(), grSession = GRSession();
            var a;
            switch (e) {
                case calltypes.webRTCCall:
                    window.console && GRCaller.onDebug("==> Load webRTC resource"), a = {
                        scripts: [libBase + "/gnum_log.js", libBase + "/tripledes.js", libBase + "/core-min.js", libBase + "/enc-utf16-min.js", libBase + "/enc-base64-min.js", libBase + "/mode-ecb-min.js", libBase + "/sip-0.7.2.js"],
                        serverIP: n.webRTC.serverIP,
                        serverPort: n.webRTC.serverPort,
                        serverRelm: "sip.gnum.com",
                        level: "debug",
                        traceSip: !0,
                        register: !1,
                        username: clientUsername,
                        password: clientPassword
                    };
                    break;
                case calltypes.flashCall:
                    window.console && GRCaller.onDebug("==> Load flash resource"), a = {
                        scripts: [libBase + "/gnum_log.js", libBase + "/tripledes.js", libBase + "/core-min.js", libBase + "/enc-utf16-min.js", libBase + "/enc-base64-min.js", libBase + "/mode-ecb-min.js", libBase + "/swfobject.js"],
                        enableDebug: "yes",
                        enableJsAPI: "yes",
                        rtmpURL: n.flash.rtmpURL,
                        debugPing: "no",
                        ScriptAccess: "always",
                        bgcolor: "#ffffff",
                        username: clientUsername,
                        password: clientPassword
                    }
            }
            a.scripts && CallerUtil.loadScripts(a.scripts, function () {
                grUserAgent.init(a)
            })
        }, supportWebRTC: function () {
            return navigator.getUserMedia = navigator.mozGetUserMedia || navigator.webkitGetUserMedia || navigator.msGetUserMedia, navigator.getUserMedia ? !0 : !1
        }, supportFlash: function () {
            var e = !1;
            try {
                var n = new ActiveXObject("ShockwaveFlash.ShockwaveFlash");
                n && (e = !0)
            } catch (a) {
                navigator.mimeTypes && void 0 != navigator.mimeTypes["application/x-shockwave-flash"] && navigator.mimeTypes["application/x-shockwave-flash"].enabledPlugin && (e = !0)
            }
            return e
        }, loadScripts: function (e, n) {
            if ("object" != typeof e)var e = [e];
            var a = document.getElementsByTagName("head").item(0) || document.documentElement, l = new Array, s = e.length - 1, t = function (o) {
                l[o] = document.createElement("script"), l[o].setAttribute("type", "text/javascript"), l[o].onload = l[o].onreadystatechange = function () {
                    this.onload = this.onreadystatechange = null, this.parentNode.removeChild(this), o != s ? t(o + 1) : "function" == typeof n && n()
                }, l[o].setAttribute("src", e[o]), a.appendChild(l[o])
            };
            t(0)
        }, browserVer: function () {
            var e = navigator.userAgent.toLowerCase(), n = "", a = this.browserName();
            try {
                n = "Firefox" == a ? e.substr(e.match(/.+(firefox)+[\/]/)[0].length).match(/([0-9]\d*\.)*[0-9]+/)[0] : "Chrome" == a ? e.substr(e.match(/.+(chrome)+[\/]/)[0].length).match(/([0-9]\d*\.)*[0-9]+/)[0] : "IE" == a ? e.substr(e.match(/.+(msie)/)[0].length).match(/([0-9]\d*\.)*[0-9]+/)[0] : e.substr(e.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+).+\)+.\b[a-zA-Z]+[\/]/)[0].length).match(/([0-9]\d*\.)*[0-9]+/)[0]
            } catch (l) {
                logger.log(l), n = $.browser.version
            }
            return n
        }, browserName: function () {
            var e = navigator.userAgent.toLowerCase(), n = "unKnow";
            try {
                /msie/i.test(e) && !/opera/.test(e) ? n = "IE" : /firefox/i.test(e) ? n = "Firefox" : /chrome/i.test(e) && /webkit/i.test(e) && /mozilla/i.test(e) ? n = "Chrome" : /opera/i.test(e) ? n = "Opera" : !/webkit/i.test(e) || /chrome/i.test(e) && /webkit/i.test(e) && /mozilla/i.test(e) ? 1 == $.browser.msie ? n = "IE" : 1 == $.browser.safari ? n = "Safari" : 1 == $.browser.opera ? n = "Opera " : 1 == $.browser.mozilla && (n = "IE") : n = "Safari"
            } catch (a) {
                logger.log(a)
            }
            return n
        }, flashVersion: function () {
            var f = "-", n = navigator;
            if (n.plugins && n.plugins.length) {
                for (var ii = 0; ii < n.plugins.length; ii++)if (-1 != n.plugins[ii].name.indexOf("Shockwave Flash")) {
                    f = n.plugins[ii].description.split("Shockwave Flash ")[1];
                    break
                }
            } else if (window.ActiveXObject)for (var ii = 10; ii >= 2; ii--)try {
                var fl = eval("new ActiveXObject('ShockwaveFlash.ShockwaveFlash." + ii + "');");
                if (fl) {
                    f = ii + ".0";
                    break
                }
            } catch (e) {
            }
            return f
        }, osName: function () {
            var e = navigator.userAgent, n = "Win32" == navigator.platform || "Windows" == navigator.platform, a = "Mac68K" == navigator.platform || "MacPPC" == navigator.platform || "Macintosh" == navigator.platform || "MacIntel" == navigator.platform;
            if (a)return "Mac";
            var l = "X11" == navigator.platform && !n && !a;
            if (l)return "Unix";
            var s = String(navigator.platform).indexOf("Linux") > -1;
            if (s)return "Linux";
            if (n) {
                var t = e.indexOf("Windows NT 5.0") > -1 || e.indexOf("Windows 2000") > -1;
                if (t)return "Win2000";
                var o = e.indexOf("Windows NT 5.1") > -1 || e.indexOf("Windows XP") > -1;
                if (o)return "WinXP";
                var r = e.indexOf("Windows NT 5.2") > -1 || e.indexOf("Windows 2003") > -1;
                if (r)return "Win2003";
                var i = e.indexOf("Windows NT 6.0") > -1 || e.indexOf("Windows Vista") > -1;
                if (i)return "WinVista";
                var c = e.indexOf("Windows NT 6.1") > -1 || e.indexOf("Windows 7") > -1;
                if (c)return "Win7"
            }
            return "other"
        }, bindMakeCallEvent: function (e) {
            Caller.onDebug("==> bind make call event"), $(e).off("click").on("click", function () {
                handlerSettings.preMakecallEvent(this), handlerSettings.onMakecallEvent(this), handlerSettings.afterMakecallEvent(this)
            })
        }, bindEndCallEvent: function (e) {
            Caller.onDebug("==> bind end call event"), $(e).off("click").on("click", function () {
                handlerSettings.preEndcallEvent(this), handlerSettings.onEndCallEvent(this), handlerSettings.afterEndcallEvent(this)
            })
        }, bindMuteEvent: function () {
            Caller.onDebug("==> bind mute event");
            var e = 0, n = handlerSettings.muteHandler;
            return null != n && "undefined" == typeof $(n)[0] ? (alert("Mute handler[" + n + "] is not defined,check again please"), !1) : void $(n).on("click", function () {
                0 == e ? (grSession.mute(), e = 1) : 1 == e && (grSession.unmute(), e = 0)
            })
        }, unbindMuteEvent: function () {
            Caller.onDebug("==> bind unmute event");
            var e = handlerSettings.muteHandler;
            return null != e && "undefined" == typeof $(e)[0] ? (alert("Mute handler[" + e + "] is not defined,check again please"), !1) : void $(e).off("click")
        }
    };
    var timerPannel = function () {
        var e = 0, n = 0, a = "", l = "", s = "", t = null;
        return {
            startTimer: function (o) {
                clearInterval(t), t = setInterval(function () {
                    e++, 60 == e && (n++, e = 0), s = e > 9 ? e : "0" + e, l = n > 9 ? n : "0" + n, a = l + ":" + s, $(o).text(a)
                }, 1e3)
            }, stopTimer: function () {
                clearInterval(t), t = null, e = 0, n = 0, a = "", l = "", s = ""
            }
        }
    };
    callTimer = timerPannel();
    var sc = null;
    return Caller = {
        serverConf: function (e) {
            var n = {
                webRTC: {serverIP: "61.8.223.35", serverPort: "5066"},
                flash: {rtmpURL: "rtmp://61.8.223.35:1935/phone;rtmpt://61.8.223.35:80/phone;rtmps://61.8.223.35:443/phone"}
            };
            sc = $.extend(n, e || {})
        }, init: function (e) {
            var n = {
                handler: null,
                muteHandler: null,
                dataAttr: "data-gnumcall",
                usernameAttr: "data-gnumUsername",
                passwordAttr: "data-gnumPassword",
                libBase: "lib",
                calltype: "auto",
                preMakecallEvent: function (e) {
                },
                afterMakecallEvent: function (e) {
                },
                preEndcallEvent: function (e) {
                },
                afterEndcallEvent: function (e) {
                }
            }, a = $.extend({}, n, e);
            return handlerSettings = {
                handler: a.handler,
                muteHandler: a.muteHandler,
                dataAttr: a.dataAttr,
                usernameAttr: a.usernameAttr,
                passwordAttr: a.passwordAttr,
                libBase: a.libBase,
                calltype: a.calltype,
                preMakecallEvent: function (e) {
                    a.preMakecallEvent(e)
                },
                afterMakecallEvent: function (e) {
                    a.afterMakecallEvent(e)
                },
                preEndcallEvent: function (e) {
                    a.preEndcallEvent(e)
                },
                afterEndcallEvent: function (e) {
                    grUserAgent.hidePrivacy(), a.afterEndcallEvent(e)
                },
                onMakecallEvent: function (e) {
                    var n = $(e).attr(handlerSettings.dataAttr);
                    Caller.makecall(n, e)
                },
                onEndCallEvent: function (e) {
                    Caller.endcall()
                }
            }, libBase = handlerSettings.libBase, calltype = CallerUtil.supportWebRTC() ? calltypes.webRTCCall : calltypes.flashCall, calltype = "auto" == handlerSettings.calltype ? calltype : handlerSettings.calltype, calltype != calltypes.webRTCCall && calltype != calltypes.flashCall ? (alert("Do not support calltype " + calltype + ",only support " + calltypes.flashCall + " or " + calltypes.webRTCCall), !1) : (clientUsername = $(handlerSettings.handler).attr(handlerSettings.usernameAttr), clientPassword = $(handlerSettings.handler).attr(handlerSettings.passwordAttr), clientUsername = null == clientUsername || "" == clientUsername || "ANONYMOUS" == clientUsername ? "unknown" : clientUsername, clientPassword = null == clientPassword || "" == clientPassword ? "" : clientPassword, "" != clientPassword && (callPrefix = "0043,0044"), updateID = $(handlerSettings.handler).attr("data-updateID"), updateID = "undefined" == typeof updateID || null == updateID || "" == updateID ? "" : updateID, sessionID = $(handlerSettings.handler).attr("data-sessionID"), sessionID = "undefined" == typeof sessionID || null == sessionID || "" == sessionID ? "" : sessionID, sc = null == sc ? Caller.serverConf() : sc, void CallerUtil.init(calltype, sc))
        }, userAgentCallbacks: function (e) {
            userAgentCallbacks = $.extend(userAgentCallbacks, e || {})
        }, getUserAgentCallbacks: function () {
            return userAgentCallbacksWraper
        }, sessionCallbacks: function (e) {
            sessionCallbacks = $.extend(sessionCallbacks, e || {})
        }, getSessionCallbacks: function () {
            return sessionCallbacksWraper
        }, getFlashCallbacks: function () {
            return flashCallbacks
        }, makecall: function (e, n) {
            grUserAgent.makecall(e, n), CallerUtil.bindEndCallEvent(n)
        }, endcall: function (e) {
            grSession.hangup(), CallerUtil.bindMakeCallEvent(e)
        }, muted: function () {
        }, unmuted: function () {
        }, dtmf: function (e) {
            grSession ? grSession.sendDtmf(e) : console.log("Session is not available")
        }, onDebug: function (e, n) {
            var a = $("#log");
            n && (a = $(n)), a.append(e + "<br/>"), window.console && console.log(e)
        }, detect: {
            browserVersion: function () {
                return CallerUtil.browserVer()
            }, browserName: function () {
                return CallerUtil.browserName()
            }, isSupportWebRTC: function () {
                return CallerUtil.supportWebRTC()
            }, osName: function () {
                return CallerUtil.osName()
            }, isSupportFlash: function () {
                return CallerUtil.supportFlash()
            }, flashVersion: function () {
                return CallerUtil.flashVersion()
            }
        }, timer: {
            start: function (e) {
                callTimer.startTimer(e)
            }, stop: function () {
                callTimer.stopTimer()
            }
        }, connect: function () {
            console.log("connecting...."), grUserAgent.connect()
        }, isConnected: function () {
            return grUserAgent.isConnected()
        }
    }, $(window).unload(function () {
        flashId = null, grUserAgent = null, grSession = null, GRUserAgent = null, GRSession = null, CallerUtil = null, userAgentCallbacks = null, userAgentCallbacksWraper = null, sessionCallbacks = null, sessionCallbacksWraper = null, flashCallbacks = null, calltype = null, handlerSettings = null, handler = null, libBase = null, callTimer = null, Caller = null
    }), Caller
}();