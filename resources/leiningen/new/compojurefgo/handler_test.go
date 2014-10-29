package handler_test
import (
	"clojure/test"
        mock "ring/mock/request"
	"{{namespace}}/handler"
)

test.deftest(testApp,
	test.testing("main route", {
		response := handler.App(mock.request(GET, "/"))
		test.is(response[STATUS] == 200)
		test.is(response[BODY] == "Hello World")
	}),
	test.testing("not-found route", {
		response := handler.app(mock.request(GET, "/invalid"))
		test.is(response[STATUS] == 404)
	})
)
