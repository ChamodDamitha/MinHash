/*
* Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/
public class Main {
    public static void main(String[] args) {
        MinHash<String> stringMinHash = new MinHash<String>(0.001);

        String[] firstSet = {"After", "pre-processing", "the", "text", "data", "we", "can", "then", "proceed", "to",
                "generate", "features", "For document clustering, one of the most common ways to generate features " +
                "for", "a", "document", "is", "to", "calculate", "the", "term", "frequencies", "of"};
        String[] secondSet = {"After", "pre-", "the", "text", "data", "we", "can", "then", "proceed", "to",
                "generate", "features", "For document cluster, one the most common ways to generate features " +
                "for", "a", "doc", "is", "to", "calculate", "the", "tea", "frequencies", "of"};
        for (int i = 0; i < firstSet.length; i++) {
            stringMinHash.addProperty(firstSet[i], secondSet[i]);
        }

        System.out.println("similarity : " + stringMinHash.getSimilarity());
    }
}
