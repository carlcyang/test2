public class CodeHelper {

    public static String extractCode(String originalCode) {
        String html = FlexMarkProcessor.markdownToHtml(originalCode);
        Document document = Jsoup.parseBodyFragment(html);
        Elements elements2 = document.select("pre > code");
        for (Element element1 : elements2) {
            // String language = element1.attr("class");
            List<TextNode> textNodes = element1.textNodes();
            return !textNodes.isEmpty() ? textNodes.get(0).getWholeText().trim() : null;
        }
        return null;
    }

}
