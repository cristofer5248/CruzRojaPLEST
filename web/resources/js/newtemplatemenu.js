
!function () {
    function a(a) {
        var b, c = [], d = document, e = d.documentElement.doScroll, f = "DOMContentLoaded", g = (e ? /^loaded|^c/ : /^loaded|^i|^c/).test(d.readyState);
        g || d.addEventListener(f, b = function () {
            for (d.removeEventListener(f, b), g = 1; b = c.shift(); )
                b()
        }), g ? setTimeout(a, 0) : c.push(a)
    }
    function b(a, b) {
        var c = !1;
        return a.split(",").forEach(function (a) {
            var d = new RegExp(a.trim().replace(".", "\\.").replace("*", "(.*)"));
            b.match(d) && (c = !0)
        }), c
    }
    function c(a) {
        "undefined" != typeof MutationObserver && new MutationObserver(a).observe(document, {childList: !0, subtree: !0})
    }
    function d(a) {
        var b, c, d, e;
        a = a || "fa", b = document.querySelectorAll("." + a), Array.prototype.forEach.call(b, function (a) {
            c = a.getAttribute("title"), a.setAttribute("aria-hidden", "true"), d = a.nextElementSibling ? !a.nextElementSibling.classList.contains("sr-only") : !0, c && d && (e = document.createElement("span"), e.innerHTML = c, e.classList.add("sr-only"), a.parentNode.insertBefore(e, a.nextSibling))
        })
    }
    !function () {
        function a(a) {
            this.el = a;
            for (var b = a.className.replace(/^\s+|\s+$/g, "").split(/\s+/), c = 0; c < b.length; c++)
                d.call(this, b[c])
        }
        function b(a, b, c) {
            Object.defineProperty ? Object.defineProperty(a, b, {get: c}) : a.__defineGetter__(b, c)
        }
        if (!("undefined" == typeof window.Element || "classList"in document.documentElement)) {
            var c = Array.prototype, d = c.push, e = c.splice, f = c.join;
            a.prototype = {add: function (a) {
                    this.contains(a) || (d.call(this, a), this.el.className = this.toString())
                }, contains: function (a) {
                    return-1 != this.el.className.indexOf(a)
                }, item: function (a) {
                    return this[a] || null
                }, remove: function (a) {
                    if (this.contains(a)) {
                        for (var b = 0; b < this.length && this[b] != a; b++)
                            ;
                        e.call(this, b, 1), this.el.className = this.toString()
                    }
                }, toString: function () {
                    return f.call(this, " ")
                }, toggle: function (a) {
                    return this.contains(a) ? this.remove(a) : this.add(a), this.contains(a)
                }}, window.DOMTokenList = a, b(Element.prototype, "classList", function () {
                return new a(this)
            })
        }
    }();
    var e, f, g, h, i, j, k, l, m, n, o = {isIE: function (a, b) {
            var c, d = "IE", e = document.createElement("B"), f = document.documentElement;
            return a && (d += " " + a, b && (d = b + " " + d)), e.innerHTML = "<!--[if " + d + ']><b id="fitest"></b><![endif]-->', f.appendChild(e), c = !!document.getElementById("fitest"), f.removeChild(e), c
        }}, p = {load: function (a) {
            var b = document.createElement("link");
            b.href = a, b.media = "all", b.rel = "stylesheet", document.getElementsByTagName("head")[0].appendChild(b)
        }, loadAsync: function (a, b, c, d) {
            var e, f = document.createElement("script"), g = {}, h = "n4", i = function () {}, j = document.scripts[0];
            window.WebFontConfig || (window.WebFontConfig = {}), g = window.WebFontConfig, g.custom || (g.custom = {}), g.custom.families || (g.custom.families = []), g.custom.urls || (g.custom.urls = []), g.custom.testStrings || (g.custom.testStrings = {}), g.custom.families.push(b), g.custom.urls.push(a), g.custom.testStrings[b] = c, e = g.fontactive || i, g.fontactive = function (a, c) {
                var d = (window.FontAwesomeHooks || {}).loaded || i;
                e(a, c), b === a && h === c && d()
            }, f.src = d, j.parentNode.insertBefore(f, j)
        }}, q = {load: function (a) {
            var b = document.createElement("script"), c = document.scripts[0];
            b.src = a, c.parentNode.appendChild(b)
        }};
    if (window.FontAwesomeCdnConfig && (e = window.FontAwesomeCdnConfig, f = e.useUrl, g = e.faCdnUrl, h = e.code, i = "FontAwesome", j = "fa", k = "", l = e.webFontLoaderVersion, e.autoA11y.enabled && (a(d.bind(d, "fa")), c(d.bind(d, "fa"))), e.reporting.enabled && b(e.reporting.domains, location.host) && q.load(g + "/js/stats.js"), n = "https://" + f + "/" + h + ".css", m = "https://" + f + "/webfontloader/" + l + "/webfontloader.js", e.asyncLoading.enabled ? p.loadAsync(n, i, k, m) : p.load(n)), window.FortAwesomeConfig) {
        var r;
        e = window.FortAwesomeConfig, f = e.useUrl, h = e.code, i = e.familyName, j = e.prefix, k = e.testString, l = e.webFontLoaderVersion, e.autoA11y.enabled && (a(d.bind(d, j)), c(d.bind(d, j))), r = o.isIE(8, "lte") ? h + "-sd" : h, n = "https://" + f + "/" + r + ".css", m = "https://use.fonticons.com/webfontloader/" + l + "/webfontloader.js", e.asyncLoading.enabled ? p.loadAsync(n, i, k, m) : p.load(n)
    }
}();