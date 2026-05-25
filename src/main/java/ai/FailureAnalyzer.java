package ai;

public class FailureAnalyzer {

    public static String analyze(Throwable error) {

        if (error == null) {
            return "Unknown failure";
        }

        String msg = error.toString().toLowerCase();

        // ================= API FAILURES =================

        if (msg.contains("401")
                || msg.contains("403")
                || msg.contains("authentication")) {

            return """
                    🔍 Failure Type: Authentication Issue
                    🧠 Root Cause:
                    Missing or invalid token/session

                    💡 Suggestion:
                    Check auth headers, token generation,
                    login flow, or session expiry.
                    """;
        }

        if (msg.contains("404")) {

            return """
                    🔍 Failure Type: Resource Not Found
                    🧠 Root Cause:
                    Incorrect endpoint or invalid test data

                    💡 Suggestion:
                    Verify API path, request URL,
                    or resource ID.
                    """;
        }

        if (msg.contains("500")) {

            return """
                    🔍 Failure Type: Internal Server Error
                    🧠 Root Cause:
                    Backend/server-side issue

                    💡 Suggestion:
                    Retry test or verify server logs.
                    """;
        }

        // ================= UI FAILURES =================

        if (msg.contains("nosuchelementexception")) {

            return """
                    🔍 Failure Type: No Such Element Exception
                    🧠 Root Cause:
                    Element not found on page.

                    💡 Suggestion:
                    Check locator strategy,
                    DOM changes,
                    iframe handling,
                    or synchronization issue.
                    """;
        }

        if (msg.contains("staleelementreferenceexception")) {

            return """
                    🔍 Failure Type: Stale Element Reference Exception
                    🧠 Root Cause:
                    Element became detached from DOM.

                    💡 Suggestion:
                    Re-locate the element before interaction
                    or add proper waits after page refresh/update.
                    """;
        }

        if (msg.contains("timeoutexception")) {

            return """
                    🔍 Failure Type: Timeout Exception
                    🧠 Root Cause:
                    Element/page did not load within wait time.

                    💡 Suggestion:
                    Increase explicit wait,
                    verify network speed,
                    or improve synchronization.
                    """;
        }

        if (msg.contains("elementclickinterceptedexception")) {

            return """
                    🔍 Failure Type: Element Click Intercepted
                    🧠 Root Cause:
                    Another element blocked click action.

                    💡 Suggestion:
                    Scroll into view,
                    wait for overlays to disappear,
                    or use JavaScript click carefully.
                    """;
        }

        if (msg.contains("elementnotinteractableexception")) {

            return """
                    🔍 Failure Type: Element Not Interactable
                    🧠 Root Cause:
                    Element exists but is hidden/disabled.

                    💡 Suggestion:
                    Wait until element becomes clickable
                    or visible before interaction.
                    """;
        }

        if (msg.contains("invalidselectorexception")) {

            return """
                    🔍 Failure Type: Invalid Selector Exception
                    🧠 Root Cause:
                    Incorrect XPath/CSS syntax.

                    💡 Suggestion:
                    Validate locator syntax carefully.
                    """;
        }

        if (msg.contains("sessionnotcreatedexception")) {

            return """
                    🔍 Failure Type: Session Not Created Exception
                    🧠 Root Cause:
                    Browser-driver mismatch.

                    💡 Suggestion:
                    Update browser,
                    webdriver,
                    or WebDriverManager setup.
                    """;
        }

        if (msg.contains("webdriverexception")) {

            return """
                    🔍 Failure Type: WebDriver Exception
                    🧠 Root Cause:
                    Browser/driver communication issue.

                    💡 Suggestion:
                    Check browser stability,
                    driver version,
                    and environment setup.
                    """;
        }

        // ================= ASSERTION =================

        if (msg.contains("assert")) {

            return """
                    🔍 Failure Type: Assertion Failure
                    🧠 Root Cause:
                    Expected vs Actual mismatch.

                    💡 Suggestion:
                    Validate test data,
                    UI content,
                    or API response values.
                    """;
        }

        // ================= DEFAULT =================

        return """
                🔍 Failure Type: Unknown Error

                💡 Suggestion:
                Check complete stacktrace manually
                for deeper investigation.
                """;
    }
}