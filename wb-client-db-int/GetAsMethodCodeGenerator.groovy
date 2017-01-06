
/*
    "catalogSource",--
    "catalogSources",--
    "countries",--
    "country",
    "dataPointCountry",
    "dataPointIndicator",
    "dataPoint",
    "dataPoints", --
    "incomeLevel",--
    "incomeLevels",--
    "indicator",--
    "indicators",====
    "indicatorSource",
    "indicatorTopic",
    "indicatorTopics",
    "lendingTypes",====
    "message",
    "region",
    "source",
    "sources",====
    "topic",--
    "topics"--
*/
def beans = [
    "dataPoints",
    "countries",
    "indicators",
    "catalogSources",
    "incomeLevels",
    "lendingTypes",
    "topics"
]

def getTemplate (it) {

def template = """
    /**
     * Do get as {@link ${it.capitalize()}} and then return that result.
     */
    public ${it.capitalize()} doGetAs${it.capitalize()} () {
        return doGetAs${it.capitalize()}(data -> { return data; });
    }

    /**
     * Do get as {@link ${it.capitalize()}}, execute the given function, and then return an instance of type
     * {@link ${it.capitalize()}}.
     */
    public ${it.capitalize()} doGetAs${it.capitalize()} (Function<${it.capitalize()}, ${it.capitalize()}> function) {
        return doGetAs${it.capitalize()}(${it.capitalize()}.class, function);
    }

    /**
     * Do get as {@link ${it.capitalize()}}, execute the given function, and then return an instance of type resultType.
     */
    public <R> R doGetAs${it.capitalize()} (Class<R> resultType, Function<${it.capitalize()}, R> function) {

        ${it.capitalize()} unconvertedResult = doGet(${it.capitalize()}.class);

        R result = function.apply(unconvertedResult);

        return result;
    }
    """
}

def file = new File ("C:/Temp/beans/generatedMethods.txt")

for (def it : beans) {
    
    def next = getTemplate (it)
    
    println(next)
    file << getTemplate (next)
}