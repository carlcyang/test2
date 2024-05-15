public class CodeHelper {

    public static String extractCode(String originalCode) {
        String html = FlexMarkProcessor.markdownToHtml(originalCode);
        Document document = Jsoup.parseBodyFragment(html);
        Elements elements = document.select("pre > code");
        for (Element element : elements) {
            // String language = element.attr("class");
            List<TextNode> textNodes = element.textNodes();
            return !textNodes.isEmpty() ? textNodes.get(0).getWholeText().trim() : null;
        }
        return null;
    }

}
