package com.example

import org.junit.Before
import org.junit.Test

import com.lesfurets.jenkins.unit.BasePipelineTest
import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.ProjectSource.projectSource

class TestCase1 extends BasePipelineTest {

    @Override
    @Before
    void setUp() throws Exception {
     
      def library = library()
                 .name('jenkinslib-example')
                 .defaultVersion('<notNeeded>')
                 .allowOverride(true)
                 .implicit(false)
                 .targetPath('<notNeeded>')
                 .retriever(projectSource())
                 .build()
        helper.registerSharedLibrary(library)

        super.setUp()
    }

    @Test
    void should_run_example_pipeline_without_errors() throws Exception {
        def script = loadScript("test/resources/pipelines/example1.pipeline")
        script.execute()
        printCallStack()
    }
}
