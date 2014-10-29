package handler
import (
	"compojure/core"
	"compojure/route"
        "ring/middleware/defaults"
)

core.defroutes(
	appRoutes,
	core.GET("/", [], "Hello World"),
	route.notFound("Not Found")
)

var App = defaults.wrapDefaults(appRoutes, defaults.siteDefaults)
