package com.speedsumm.bu.a2_l4;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by bu on 02.08.2016.
 */
public class GetNews extends AsyncTask<String, Void, ArrayList<News>> {
    NodeList nodeList;
    private static final String ns = null;
    String taskHead, taskBody;

    @Override
    protected ArrayList<News> doInBackground(String... Url) {
        ArrayList<News> newses = new ArrayList<News>();

//        try {
//            URL url = new URL(Url[0]);
//            URLConnection conn = url.openConnection();
//
//            XmlPullParser parser = Xml.newPullParser();
//            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
//            parser.setInput(conn.getInputStream(), null);
//            parser.nextTag();
//            News news  = getNode(parser);
//            newses.add(news);
//
//
//
//        } catch (XmlPullParserException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            URL url = new URL(Url[0]);
            URLConnection conn = url.openConnection();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(conn.getInputStream());
            doc.getDocumentElement().normalize();
            nodeList = doc.getElementsByTagName("CD");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                newses.add(new News(getNode("TITLE", element), (getNode("YEAR", element))));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
            {
                e.printStackTrace();
            }


        }
        return newses;
    }


    private String getNode(String TAG, Element element) {
        NodeList nList = element.getElementsByTagName(TAG).item(0).getChildNodes();
        Node node = (Node) nList.item(0);


//        try {
//            parser.require(XmlPullParser.START_TAG, ns, "CD");
//            while (parser.next() != XmlPullParser.END_TAG) {
//                switch (parser.getEventType()) {
//                    case XmlPullParser.START_DOCUMENT:
//                        Log.d("....", "START DOCUMENT");
//                        break;
//                    case XmlPullParser.START_TAG:
//                        Log.d("....", "START TAG: " + parser.getName() + ", число атрибутов " + parser.getAttributeCount());
//                        Log.d("....","TAG TEXT: "+parser.getText());
//
//                        break;
//                    case XmlPullParser.END_TAG:
//                        Log.d("....", "END_TAG: " + parser.getName());
//                        break;
//                    case XmlPullParser.TEXT:
//                        Log.d("....", "TEXT: " + parser.getText());
//                        break;
//                    default:
//                        break;
//                }
//                parser.next();
//
//                }
//                if (parser.getEventType() != XmlPullParser.START_TAG) {
//                    String name = parser.getName();
//                    if (name.equals("TITLE")){
//                        parser.require(XmlPullParser.START_TAG,null,"TITLE");
//                         taskHead = parser.getText();
//                        parser.nextTag();
//                        parser.require(XmlPullParser.END_TAG,null,"TITLE");
//                    } else if (name.equals("YEAR")){
//                        parser.require(XmlPullParser.START_TAG,null,"YEAR");
//                         taskBody = parser.getText();
//                        parser.nextTag();
//                        parser.require(XmlPullParser.END_TAG,null,"YEAR");
//                    }
//                }
//            } catch (XmlPullParserException e1) {
//            e1.printStackTrace();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }


        return node.getNodeValue();
    }
}

