package com.apimastery.snakeyaml.scanner;

import java.util.Iterator;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.scanner.ScannerException;

public class TripleQuotedLiteralScalarTest
{

   // System.out.println("--- # yamlSimlet:");
   // System.out.println(yamlSimlet);
   // System.out.println("--- # yaml.dump:");
   // System.out.println(yaml.dump(doc));

   @Test
   public void test_EndsWithNewLine_FollowedByMoreSameLevelFields() throws Exception
   {
      // @formatter:off
      String yamlSimlet = "" +
         "response:\n" +
         "  from: stub\n" +
         "  body: \"\"\"\n" +
         "{\n" +
         "  \"status\": \"OK\"\n" +
         "}\n" +
         // ends on new line
         "\"\"\"\n" +
         // ...and followed by a field at the same indentation level
         "  status: 200\n" +
         "rank: 1" +
         "";
      // @formatter:on

      final Yaml yaml = new Yaml();

      final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
      final Iterator<Object> docsIterator = docs.iterator();
      while (docsIterator.hasNext())
      {
         final Object doc = docsIterator.next();

         @SuppressWarnings("unchecked")
         final Map<String, Object> map = (Map<String, Object>)doc;
         @SuppressWarnings("rawtypes")
         final String body = (String)((Map)map.get("response")).get("body");
         // @formatter:off
         final String expectedBody = "" +
            "{\n" +
            "  \"status\": \"OK\"\n" +
            "}\n" +
            "";
         // @formatter:on
         Assert.assertEquals(expectedBody, body);
      }
   }

   @Test
   public void test_EndsWithNewLine_FollowedByFieldAtOuterLevel() throws Exception
   {
      // @formatter:off
      String yamlSimlet = "" +
         "response:\n" +
         "  from: stub\n" +
         "  body: \"\"\"\n" +
         "{\n" +
         "  \"status\": \"OK\"\n" +
         "}\n" +
         // ends on new line
         "\"\"\"\n" +
         // ...and followed by a field at the parent's (outer) indentation level
         "rank: 1" +
         "";
      // @formatter:on

      final Yaml yaml = new Yaml();

      final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
      final Iterator<Object> docsIterator = docs.iterator();
      while (docsIterator.hasNext())
      {
         final Object doc = docsIterator.next();

         @SuppressWarnings("unchecked")
         final Map<String, Object> map = (Map<String, Object>)doc;
         @SuppressWarnings("rawtypes")
         final String body = (String)((Map)map.get("response")).get("body");
         // @formatter:off
         final String expectedBody = "" +
            "{\n" +
            "  \"status\": \"OK\"\n" +
            "}\n" +
            "";
         // @formatter:on
         Assert.assertEquals(expectedBody, body);
      }
   }

   @Test
   public void test_EndsWithNewLine_NothingAfterIt() throws Exception
   {
      // @formatter:off
      String yamlSimlet = "" +
         "response:\n" +
         "  from: stub\n" +
         "  body: \"\"\"\n" +
         "{\n" +
         "  \"status\": \"OK\"\n" +
         "}\n" +
         // ends on new line
         "\"\"\"" +
         // ...and nothing after it
         "";
      // @formatter:on

      final Yaml yaml = new Yaml();

      final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
      final Iterator<Object> docsIterator = docs.iterator();
      while (docsIterator.hasNext())
      {
         final Object doc = docsIterator.next();

         @SuppressWarnings("unchecked")
         final Map<String, Object> map = (Map<String, Object>)doc;
         @SuppressWarnings("rawtypes")
         final String body = (String)((Map)map.get("response")).get("body");
         // @formatter:off
         final String expectedBody = "" +
            "{\n" +
            "  \"status\": \"OK\"\n" +
            "}\n" +
            "";
         // @formatter:on
         Assert.assertEquals(expectedBody, body);
      }
   }

   @Test
   public void test_EndsOnLastLine_FollowedByFieldAtSameLevel() throws Exception
   {
      // @formatter:off
      String yamlSimlet = "" +
         "response:\n" +
         "  from: stub\n" +
         "  body: \"\"\"\n" +
         "{\n" +
         "  \"status\": \"OK\"\n" +
         "} \"\"\"\n" +
         // ...and followed by a field at the same indentation level
         "  status: 200\n" +
         "rank: 1" +
         "";
      // @formatter:on

      final Yaml yaml = new Yaml();

      final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
      final Iterator<Object> docsIterator = docs.iterator();
      while (docsIterator.hasNext())
      {
         final Object doc = docsIterator.next();

         @SuppressWarnings("unchecked")
         final Map<String, Object> map = (Map<String, Object>)doc;
         @SuppressWarnings("rawtypes")
         final String body = (String)((Map)map.get("response")).get("body");
         // @formatter:off
         final String expectedBody = "" +
            "{\n" +
            "  \"status\": \"OK\"\n" +
            "} " +
            "";
         // @formatter:on
         Assert.assertEquals(expectedBody, body);
      }
   }

   @Test
   public void test_EndsOnLastLine_FollowedByFieldAtOuterLevel() throws Exception
   {
      // @formatter:off
      String yamlSimlet = "" +
         "response:\n" +
         "  from: stub\n" +
         "  body: \"\"\"\n" +
         "{\n" +
         "  \"status\": \"OK\"\n" +
         "} \"\"\"\n" +
         // ...and followed by a field at the parent's (outer) indentation level
         "rank: 1" +
         "";
      // @formatter:on

      final Yaml yaml = new Yaml();

      final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
      final Iterator<Object> docsIterator = docs.iterator();
      while (docsIterator.hasNext())
      {
         final Object doc = docsIterator.next();

         @SuppressWarnings("unchecked")
         final Map<String, Object> map = (Map<String, Object>)doc;
         @SuppressWarnings("rawtypes")
         final String body = (String)((Map)map.get("response")).get("body");
         // @formatter:off
         final String expectedBody = "" +
            "{\n" +
            "  \"status\": \"OK\"\n" +
            "} " +
            "";
         // @formatter:on
         Assert.assertEquals(expectedBody, body);
      }
   }

   @Test
   public void test_EndsOnLastLine_NothingAfterIt() throws Exception
   {
      // @formatter:off
      String yamlSimlet = "" +
         "response:\n" +
         "  from: stub\n" +
         "  body: \"\"\"\n" +
         "{\n" +
         "  \"status\": \"OK\"\n" +
         "} \"\"\"" +
         // ...and nothing after it
         "";
      // @formatter:on

      final Yaml yaml = new Yaml();

      final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
      final Iterator<Object> docsIterator = docs.iterator();
      while (docsIterator.hasNext())
      {
         final Object doc = docsIterator.next();

         @SuppressWarnings("unchecked")
         final Map<String, Object> map = (Map<String, Object>)doc;
         @SuppressWarnings("rawtypes")
         final String body = (String)((Map)map.get("response")).get("body");
         // @formatter:off
         final String expectedBody = "" +
            "{\n" +
            "  \"status\": \"OK\"\n" +
            "} " +
            "";
         // @formatter:on
         Assert.assertEquals(expectedBody, body);
      }
   }

   @Test
   public void test_EndsOnLastLine_FollowedBy() throws Exception
   {
      // @formatter:off
      String yamlSimlet = "" +
         "response:\n" +
         "  from: stub\n" +
         "  body: \"\"\"\n" +
         "{\n" +
         "  \"status\": \"OK\"\n" +
         "} \"\"\"\n" +
         // ...and nothing after the new line (\n)
         "";
      // @formatter:on

      final Yaml yaml = new Yaml();

      final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
      final Iterator<Object> docsIterator = docs.iterator();
      while (docsIterator.hasNext())
      {
         final Object doc = docsIterator.next();

         @SuppressWarnings("unchecked")
         final Map<String, Object> map = (Map<String, Object>)doc;
         @SuppressWarnings("rawtypes")
         final String body = (String)((Map)map.get("response")).get("body");
         // @formatter:off
         final String expectedBody = "" +
            "{\n" +
            "  \"status\": \"OK\"\n" +
            "} " +
            "";
         // @formatter:on
         Assert.assertEquals(expectedBody, body);
      }
   }


   @Test
   public void test_FirstCharIsRightAfterTheQuotes()
   {
      // @formatter:off
      String yamlSimlet = "" +
         "response:\n" +
         "  from: stub\n" +
         // The text starts right after the triple quotes instead of a new line after that
         "  body: \"\"\"{\n" +
         "  \"status\": \"OK\"\n" +
         "} \"\"\"\n" +
         "";
      // @formatter:on

      final Yaml yaml = new Yaml();
      try
      {
         final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
         final Iterator<Object> docsIterator = docs.iterator();
         while (docsIterator.hasNext())
         {
            // This call should throw the exception we catch and process below
            docsIterator.next();

            Assert.fail("Expected " + ScannerException.class.getName());
         }
      }
      catch (ScannerException e)
      {
         // This is expected
         Assert.assertTrue(e.getMessage().contains("expected end of line but got { (123)"));
      }
   }

   @Test
   public void test_EndsOnSameLineWhereItStarts() throws Exception
   {
      // @formatter:off
      String yamlSimlet = ""
         + "response:\n"
         + "  from: stub\n"
         + "  body: \"\"\"{\n  \"status\": \"OK\"\n}\"\"\"\n"
         + "";
      // @formatter:on

      final Yaml yaml = new Yaml();
      try
      {
         final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
         final Iterator<Object> docsIterator = docs.iterator();
         while (docsIterator.hasNext())
         {
            // This call should throw the exception we catch and process below
            docsIterator.next();

            Assert.fail("Expected " + ScannerException.class.getName());
         }
      }
      catch (ScannerException e)
      {
         // This is expected
         Assert.assertTrue(e.getMessage().contains("scanning for end of line"));
         Assert.assertTrue(e.getMessage().contains("expected end of line but got { (123)"));
      }
   }
   
   @Test
   public void test_NothingAfterItAndMissingEndQuotes()
   {
      // @formatter:off
      String yamlSimlet = "" +
         "response:\n" +
         "  from: stub\n" +
         // The text starts right after the triple quotes instead of a new line after that
         "  body: \"\"\"\n" +
         "{\n" +
         "  \"status\": \"OK\"\n" +
         "}" +
         "";
      // @formatter:on

      final Yaml yaml = new Yaml();
      try
      {
         final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
         final Iterator<Object> docsIterator = docs.iterator();
         while (docsIterator.hasNext())
         {
            // This call should throw the exception we catch and process below
            docsIterator.next();

            Assert.fail("Expected " + ScannerException.class.getName());
         }
      }
      catch (ScannerException e)
      {
         // This is expected
         Assert.assertTrue(e.getMessage().contains("scanning for \"\"\""));
         Assert.assertTrue(e.getMessage().contains("unexpected end of stream"));
      }
   }

   @Test
   public void test_EndOfStreamAfterOpeningQuotes()
   {
      // @formatter:off
      String yamlSimlet = "" +
         "response:\n" +
         "  from: stub\n" +
         // EOF right after the triple quotes
         "  body: \"\"\"" +
         "";
      // @formatter:on

      final Yaml yaml = new Yaml();
      try
      {
         final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
         final Iterator<Object> docsIterator = docs.iterator();
         while (docsIterator.hasNext())
         {
            // This call should throw the exception we catch and process below
            docsIterator.next();

            Assert.fail("Expected " + ScannerException.class.getName());
         }
      }
      catch (ScannerException e)
      {
         // This is expected
         Assert.assertTrue(e.getMessage().contains("scanning for end of line"));
         Assert.assertTrue(e.getMessage().contains("expected end of line but got end of stream"));
      }
   }

   @Test
   public void test_EndOfStreamAfterOpeningQuotesFollowedByNewLine()
   {
      // @formatter:off
      String yamlSimlet = "" +
         "response:\n" +
         "  from: stub\n" +
         // EOF right after the new line that follows the opening triple quotes
         "  body: \"\"\"\n" +
         "";
      // @formatter:on

      final Yaml yaml = new Yaml();
      try
      {
         final Iterable<Object> docs = yaml.loadAll(yamlSimlet);
         final Iterator<Object> docsIterator = docs.iterator();
         while (docsIterator.hasNext())
         {
            // This call should throw the exception we catch and process below
            docsIterator.next();

            Assert.fail("Expected " + ScannerException.class.getName());
         }
      }
      catch (ScannerException e)
      {
         // This is expected
         Assert.assertTrue(e.getMessage().contains("scanning for \"\"\""));
         Assert.assertTrue(e.getMessage().contains("unexpected end of stream"));
      }
   }

}
