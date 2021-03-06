/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.organizations;

import static java.util.concurrent.Executors.newFixedThreadPool;

import javax.annotation.Generated;

import com.amazonaws.services.organizations.model.*;
import com.amazonaws.client.AwsAsyncClientParams;
import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.concurrent.ExecutorService;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

/**
 * Client for accessing Organizations asynchronously. Each asynchronous method will return a Java Future object
 * representing the asynchronous operation; overloads which accept an {@code AsyncHandler} can be used to receive
 * notification when an asynchronous operation completes.
 * <p>
 * <fullname>AWS Organizations API Reference</fullname>
 * <p>
 * AWS Organizations is a web service that enables you to consolidate your multiple AWS accounts into an
 * <i>organization</i> and centrally manage your accounts and their resources.
 * </p>
 * <p>
 * This guide provides descriptions of the Organizations API. For more information about using this service, see the <a
 * href="http://docs.aws.amazon.com/Organizations/latest/UserGuide/orgs_introduction.html">AWS Organizations User
 * Guide</a>.
 * </p>
 * <p>
 * <b>API Version</b>
 * </p>
 * <p>
 * This version of the Organizations API Reference documents the Organizations API version 2016-11-28.
 * </p>
 * <note>
 * <p>
 * As an alternative to using the API directly, you can use one of the AWS SDKs, which consist of libraries and sample
 * code for various programming languages and platforms (Java, Ruby, .NET, iOS, Android, and more). The SDKs provide a
 * convenient way to create programmatic access to AWS Organizations. For example, the SDKs take care of
 * cryptographically signing requests, managing errors, and retrying requests automatically. For more information about
 * the AWS SDKs, including how to download and install them, see <a href="http://aws.amazon.com/tools/">Tools for Amazon
 * Web Services</a>.
 * </p>
 * </note>
 * <p>
 * We recommend that you use the AWS SDKs to make programmatic API calls to Organizations. However, you also can use the
 * Organizations Query API to make direct calls to the Organizations web service. To learn more about the Organizations
 * Query API, see <a href="http://docs.aws.amazon.com/organizations/latest/UserGuide/orgs_query-requests.html">Making
 * Query Requests</a> in the <i>AWS Organizations User Guide</i>. Organizations supports GET and POST requests for all
 * actions. That is, the API does not require you to use GET for some actions and POST for others. However, GET requests
 * are subject to the limitation size of a URL. Therefore, for operations that require larger sizes, use a POST request.
 * </p>
 * <p>
 * <b>Signing Requests</b>
 * </p>
 * <p>
 * When you send HTTP requests to AWS, you must sign the requests so that AWS can identify who sent them. You sign
 * requests with your AWS access key, which consists of an access key ID and a secret access key. We strongly recommend
 * that you do not create an access key for your root account. Anyone who has the access key for your root account has
 * unrestricted access to all the resources in your account. Instead, create an access key for an IAM user account that
 * has administrative privileges. As another option, use AWS Security Token Service to generate temporary security
 * credentials, and use those credentials to sign requests.
 * </p>
 * <p>
 * To sign requests, we recommend that you use <a
 * href="http://docs.aws.amazon.com/general/latest/gr/signature-version-4.html">Signature Version 4</a>. If you have an
 * existing application that uses Signature Version 2, you do not have to update it to use Signature Version 4. However,
 * some operations now require Signature Version 4. The documentation for operations that require version 4 indicate
 * this requirement.
 * </p>
 * <p>
 * When you use the AWS Command Line Interface (AWS CLI) or one of the AWS SDKs to make requests to AWS, these tools
 * automatically sign the requests for you with the access key that you specify when you configure the tools.
 * </p>
 * <p>
 * In this release, each organization can have only one root. In a future release, a single organization will support
 * multiple roots.
 * </p>
 * <p>
 * <b>Support and Feedback for AWS Organizations</b>
 * </p>
 * <p>
 * We welcome your feedback. Send your comments to <a
 * href="mailto:feedback-awsorganizations@amazon.com">feedback-awsorganizations@amazon.com</a> or post your feedback and
 * questions in our private <a href="https://forums.aws.amazon.com/forum.jspa?forumID=219">AWS Organizations support
 * forum</a>. If you don't have access to the forum, send a request for access to the email address, along with your
 * forum user ID. For more information about the AWS support forums, see <a
 * href="https://forums.aws.amazon.com/help.jspa">Forums Help</a>.
 * </p>
 * <p>
 * <b>Endpoint to Call When Using the CLI or the AWS API</b>
 * </p>
 * <p>
 * For the current release of Organizations, you must specify the <code>us-east-1</code> region for all AWS API and CLI
 * calls. You can do this in the CLI by using these parameters and commands:
 * </p>
 * <ul>
 * <li>
 * <p>
 * Use the following parameter with each command to specify both the endpoint and its region:
 * </p>
 * <p>
 * <code>--endpoint-url https://organizations.us-east-1.amazonaws.com</code>
 * </p>
 * </li>
 * <li>
 * <p>
 * Use the default endpoint, but configure your default region with this command:
 * </p>
 * <p>
 * <code>aws configure set default.region us-east-1</code>
 * </p>
 * </li>
 * <li>
 * <p>
 * Use the following parameter with each command to specify the endpoint:
 * </p>
 * <p>
 * <code>--region us-east-1</code>
 * </p>
 * </li>
 * </ul>
 * <p>
 * For the various SDKs used to call the APIs, see the documentation for the SDK of interest to learn how to direct the
 * requests to a specific endpoint. For more information, see <a
 * href="http://docs.aws.amazon.com/general/latest/gr/rande.html#sts_region">Regions and Endpoints</a> in the <i>AWS
 * General Reference</i>.
 * </p>
 * <p>
 * <b>How examples are presented</b>
 * </p>
 * <p>
 * The JSON returned by the AWS Organizations service as response to your requests is returned as a single long string
 * without line breaks or formatting whitespace. Both line breaks and whitespace are included in the examples in this
 * guide to improve readability. When example input parameters also would result in long strings that would extend
 * beyond the screen, we insert line breaks to enhance readability. You should always submit the input as a single JSON
 * text string.
 * </p>
 * <p>
 * <b>Recording API Requests</b>
 * </p>
 * <p>
 * AWS Organizations supports AWS CloudTrail, a service that records AWS API calls for your AWS account and delivers log
 * files to an Amazon S3 bucket. By using information collected by AWS CloudTrail, you can determine which requests were
 * successfully made to Organizations, who made the request, when it was made, and so on. For more about AWS
 * Organizations and its support for AWS CloudTrail, see <a
 * href="http://docs.aws.amazon.com/organizations/latest/userguide/orgs_cloudtrail-integration.html">Logging AWS
 * Organizations Events with AWS CloudTrail</a> in the <i>AWS Organizations User Guide</i>. To learn more about
 * CloudTrail, including how to turn it on and find your log files, see the <a
 * href="http://docs.aws.amazon.com/awscloudtrail/latest/userguide/what_is_cloud_trail_top_level.html">AWS CloudTrail
 * User Guide</a>.
 * </p>
 */
@ThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class AWSOrganizationsAsyncClient extends AWSOrganizationsClient implements AWSOrganizationsAsync {

    private static final int DEFAULT_THREAD_POOL_SIZE = 50;

    private final java.util.concurrent.ExecutorService executorService;

    /**
     * Constructs a new asynchronous client to invoke service methods on Organizations. A credentials provider chain
     * will be used that searches for credentials in this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Credential profiles file at the default location (~/.aws/credentials) shared by all AWS SDKs and the AWS CLI</li>
     * <li>Instance profile credentials delivered through the Amazon EC2 metadata service</li>
     * </ul>
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing 50 threads (to match the default
     * maximum number of concurrent connections to the service).
     *
     * @see com.amazonaws.auth.DefaultAWSCredentialsProviderChain
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     * @deprecated use {@link AWSOrganizationsAsyncClientBuilder#defaultClient()}
     */
    @Deprecated
    public AWSOrganizationsAsyncClient() {
        this(DefaultAWSCredentialsProviderChain.getInstance());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Organizations. A credentials provider chain
     * will be used that searches for credentials in this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Credential profiles file at the default location (~/.aws/credentials) shared by all AWS SDKs and the AWS CLI</li>
     * <li>Instance profile credentials delivered through the Amazon EC2 metadata service</li>
     * </ul>
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing a number of threads equal to the
     * maximum number of concurrent connections configured via {@code ClientConfiguration.getMaxConnections()}.
     *
     * @param clientConfiguration
     *        The client configuration options controlling how this client connects to Organizations (ex: proxy
     *        settings, retry counts, etc).
     *
     * @see com.amazonaws.auth.DefaultAWSCredentialsProviderChain
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     * @deprecated use {@link AWSOrganizationsAsyncClientBuilder#withClientConfiguration(ClientConfiguration)}
     */
    @Deprecated
    public AWSOrganizationsAsyncClient(ClientConfiguration clientConfiguration) {
        this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration, newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Organizations using the specified AWS account
     * credentials.
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing 50 threads (to match the default
     * maximum number of concurrent connections to the service).
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when authenticating with AWS services.
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     * @deprecated use {@link AWSOrganizationsAsyncClientBuilder#withCredentials(AWSCredentialsProvider)}
     */
    @Deprecated
    public AWSOrganizationsAsyncClient(AWSCredentials awsCredentials) {
        this(awsCredentials, newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Organizations using the specified AWS account
     * credentials and executor service. Default client settings will be used.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when authenticating with AWS services.
     * @param executorService
     *        The executor service by which all asynchronous requests will be executed.
     * @deprecated use {@link AWSOrganizationsAsyncClientBuilder#withCredentials(AWSCredentialsProvider)} and
     *             {@link AWSOrganizationsAsyncClientBuilder#withExecutorFactory(com.amazonaws.client.builder.ExecutorFactory)}
     */
    @Deprecated
    public AWSOrganizationsAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService) {

        this(awsCredentials, configFactory.getConfig(), executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Organizations using the specified AWS account
     * credentials, executor service, and client configuration options.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when authenticating with AWS services.
     * @param clientConfiguration
     *        Client configuration options (ex: max retry limit, proxy settings, etc).
     * @param executorService
     *        The executor service by which all asynchronous requests will be executed.
     * @deprecated use {@link AWSOrganizationsAsyncClientBuilder#withCredentials(AWSCredentialsProvider)} and
     *             {@link AWSOrganizationsAsyncClientBuilder#withClientConfiguration(ClientConfiguration)} and
     *             {@link AWSOrganizationsAsyncClientBuilder#withExecutorFactory(com.amazonaws.client.builder.ExecutorFactory)}
     */
    @Deprecated
    public AWSOrganizationsAsyncClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(awsCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Organizations using the specified AWS account
     * credentials provider. Default client settings will be used.
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing 50 threads (to match the default
     * maximum number of concurrent connections to the service).
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to authenticate requests with AWS services.
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     * @deprecated use {@link AWSOrganizationsAsyncClientBuilder#withCredentials(AWSCredentialsProvider)}
     */
    @Deprecated
    public AWSOrganizationsAsyncClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Organizations using the provided AWS account
     * credentials provider and client configuration options.
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing a number of threads equal to the
     * maximum number of concurrent connections configured via {@code ClientConfiguration.getMaxConnections()}.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to authenticate requests with AWS services.
     * @param clientConfiguration
     *        Client configuration options (ex: max retry limit, proxy settings, etc).
     *
     * @see com.amazonaws.auth.DefaultAWSCredentialsProviderChain
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     * @deprecated use {@link AWSOrganizationsAsyncClientBuilder#withCredentials(AWSCredentialsProvider)} and
     *             {@link AWSOrganizationsAsyncClientBuilder#withClientConfiguration(ClientConfiguration)}
     */
    @Deprecated
    public AWSOrganizationsAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Organizations using the specified AWS account
     * credentials provider and executor service. Default client settings will be used.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to authenticate requests with AWS services.
     * @param executorService
     *        The executor service by which all asynchronous requests will be executed.
     * @deprecated use {@link AWSOrganizationsAsyncClientBuilder#withCredentials(AWSCredentialsProvider)} and
     *             {@link AWSOrganizationsAsyncClientBuilder#withExecutorFactory(com.amazonaws.client.builder.ExecutorFactory)}
     */
    @Deprecated
    public AWSOrganizationsAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService) {
        this(awsCredentialsProvider, configFactory.getConfig(), executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Organizations using the specified AWS account
     * credentials provider, executor service, and client configuration options.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to authenticate requests with AWS services.
     * @param clientConfiguration
     *        Client configuration options (ex: max retry limit, proxy settings, etc).
     * @param executorService
     *        The executor service by which all asynchronous requests will be executed.
     * @deprecated use {@link AWSOrganizationsAsyncClientBuilder#withCredentials(AWSCredentialsProvider)} and
     *             {@link AWSOrganizationsAsyncClientBuilder#withClientConfiguration(ClientConfiguration)} and
     *             {@link AWSOrganizationsAsyncClientBuilder#withExecutorFactory(com.amazonaws.client.builder.ExecutorFactory)}
     */
    @Deprecated
    public AWSOrganizationsAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(awsCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public static AWSOrganizationsAsyncClientBuilder asyncBuilder() {
        return AWSOrganizationsAsyncClientBuilder.standard();
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Organizations using the specified parameters.
     *
     * @param asyncClientParams
     *        Object providing client parameters.
     */
    AWSOrganizationsAsyncClient(AwsAsyncClientParams asyncClientParams) {
        super(asyncClientParams);
        this.executorService = asyncClientParams.getExecutor();
    }

    /**
     * Returns the executor service used by this client to execute async requests.
     *
     * @return The executor service used by this client to execute async requests.
     */
    public ExecutorService getExecutorService() {
        return executorService;
    }

    @Override
    public java.util.concurrent.Future<AcceptHandshakeResult> acceptHandshakeAsync(AcceptHandshakeRequest request) {

        return acceptHandshakeAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<AcceptHandshakeResult> acceptHandshakeAsync(final AcceptHandshakeRequest request,
            final com.amazonaws.handlers.AsyncHandler<AcceptHandshakeRequest, AcceptHandshakeResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<AcceptHandshakeResult>() {
            @Override
            public AcceptHandshakeResult call() throws Exception {
                AcceptHandshakeResult result;

                try {
                    result = acceptHandshake(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<AttachPolicyResult> attachPolicyAsync(AttachPolicyRequest request) {

        return attachPolicyAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<AttachPolicyResult> attachPolicyAsync(final AttachPolicyRequest request,
            final com.amazonaws.handlers.AsyncHandler<AttachPolicyRequest, AttachPolicyResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<AttachPolicyResult>() {
            @Override
            public AttachPolicyResult call() throws Exception {
                AttachPolicyResult result;

                try {
                    result = attachPolicy(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<CancelHandshakeResult> cancelHandshakeAsync(CancelHandshakeRequest request) {

        return cancelHandshakeAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CancelHandshakeResult> cancelHandshakeAsync(final CancelHandshakeRequest request,
            final com.amazonaws.handlers.AsyncHandler<CancelHandshakeRequest, CancelHandshakeResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<CancelHandshakeResult>() {
            @Override
            public CancelHandshakeResult call() throws Exception {
                CancelHandshakeResult result;

                try {
                    result = cancelHandshake(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<CreateAccountResult> createAccountAsync(CreateAccountRequest request) {

        return createAccountAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CreateAccountResult> createAccountAsync(final CreateAccountRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateAccountRequest, CreateAccountResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<CreateAccountResult>() {
            @Override
            public CreateAccountResult call() throws Exception {
                CreateAccountResult result;

                try {
                    result = createAccount(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<CreateOrganizationResult> createOrganizationAsync(CreateOrganizationRequest request) {

        return createOrganizationAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CreateOrganizationResult> createOrganizationAsync(final CreateOrganizationRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateOrganizationRequest, CreateOrganizationResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<CreateOrganizationResult>() {
            @Override
            public CreateOrganizationResult call() throws Exception {
                CreateOrganizationResult result;

                try {
                    result = createOrganization(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<CreateOrganizationalUnitResult> createOrganizationalUnitAsync(CreateOrganizationalUnitRequest request) {

        return createOrganizationalUnitAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CreateOrganizationalUnitResult> createOrganizationalUnitAsync(final CreateOrganizationalUnitRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateOrganizationalUnitRequest, CreateOrganizationalUnitResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<CreateOrganizationalUnitResult>() {
            @Override
            public CreateOrganizationalUnitResult call() throws Exception {
                CreateOrganizationalUnitResult result;

                try {
                    result = createOrganizationalUnit(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<CreatePolicyResult> createPolicyAsync(CreatePolicyRequest request) {

        return createPolicyAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CreatePolicyResult> createPolicyAsync(final CreatePolicyRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreatePolicyRequest, CreatePolicyResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<CreatePolicyResult>() {
            @Override
            public CreatePolicyResult call() throws Exception {
                CreatePolicyResult result;

                try {
                    result = createPolicy(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DeclineHandshakeResult> declineHandshakeAsync(DeclineHandshakeRequest request) {

        return declineHandshakeAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DeclineHandshakeResult> declineHandshakeAsync(final DeclineHandshakeRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeclineHandshakeRequest, DeclineHandshakeResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DeclineHandshakeResult>() {
            @Override
            public DeclineHandshakeResult call() throws Exception {
                DeclineHandshakeResult result;

                try {
                    result = declineHandshake(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DeleteOrganizationResult> deleteOrganizationAsync(DeleteOrganizationRequest request) {

        return deleteOrganizationAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DeleteOrganizationResult> deleteOrganizationAsync(final DeleteOrganizationRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeleteOrganizationRequest, DeleteOrganizationResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DeleteOrganizationResult>() {
            @Override
            public DeleteOrganizationResult call() throws Exception {
                DeleteOrganizationResult result;

                try {
                    result = deleteOrganization(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DeleteOrganizationalUnitResult> deleteOrganizationalUnitAsync(DeleteOrganizationalUnitRequest request) {

        return deleteOrganizationalUnitAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DeleteOrganizationalUnitResult> deleteOrganizationalUnitAsync(final DeleteOrganizationalUnitRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeleteOrganizationalUnitRequest, DeleteOrganizationalUnitResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DeleteOrganizationalUnitResult>() {
            @Override
            public DeleteOrganizationalUnitResult call() throws Exception {
                DeleteOrganizationalUnitResult result;

                try {
                    result = deleteOrganizationalUnit(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DeletePolicyResult> deletePolicyAsync(DeletePolicyRequest request) {

        return deletePolicyAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DeletePolicyResult> deletePolicyAsync(final DeletePolicyRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeletePolicyRequest, DeletePolicyResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DeletePolicyResult>() {
            @Override
            public DeletePolicyResult call() throws Exception {
                DeletePolicyResult result;

                try {
                    result = deletePolicy(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DescribeAccountResult> describeAccountAsync(DescribeAccountRequest request) {

        return describeAccountAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeAccountResult> describeAccountAsync(final DescribeAccountRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeAccountRequest, DescribeAccountResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DescribeAccountResult>() {
            @Override
            public DescribeAccountResult call() throws Exception {
                DescribeAccountResult result;

                try {
                    result = describeAccount(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DescribeCreateAccountStatusResult> describeCreateAccountStatusAsync(DescribeCreateAccountStatusRequest request) {

        return describeCreateAccountStatusAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeCreateAccountStatusResult> describeCreateAccountStatusAsync(final DescribeCreateAccountStatusRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeCreateAccountStatusRequest, DescribeCreateAccountStatusResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DescribeCreateAccountStatusResult>() {
            @Override
            public DescribeCreateAccountStatusResult call() throws Exception {
                DescribeCreateAccountStatusResult result;

                try {
                    result = describeCreateAccountStatus(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DescribeHandshakeResult> describeHandshakeAsync(DescribeHandshakeRequest request) {

        return describeHandshakeAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeHandshakeResult> describeHandshakeAsync(final DescribeHandshakeRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeHandshakeRequest, DescribeHandshakeResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DescribeHandshakeResult>() {
            @Override
            public DescribeHandshakeResult call() throws Exception {
                DescribeHandshakeResult result;

                try {
                    result = describeHandshake(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DescribeOrganizationResult> describeOrganizationAsync(DescribeOrganizationRequest request) {

        return describeOrganizationAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeOrganizationResult> describeOrganizationAsync(final DescribeOrganizationRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeOrganizationRequest, DescribeOrganizationResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DescribeOrganizationResult>() {
            @Override
            public DescribeOrganizationResult call() throws Exception {
                DescribeOrganizationResult result;

                try {
                    result = describeOrganization(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DescribeOrganizationalUnitResult> describeOrganizationalUnitAsync(DescribeOrganizationalUnitRequest request) {

        return describeOrganizationalUnitAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeOrganizationalUnitResult> describeOrganizationalUnitAsync(final DescribeOrganizationalUnitRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeOrganizationalUnitRequest, DescribeOrganizationalUnitResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DescribeOrganizationalUnitResult>() {
            @Override
            public DescribeOrganizationalUnitResult call() throws Exception {
                DescribeOrganizationalUnitResult result;

                try {
                    result = describeOrganizationalUnit(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DescribePolicyResult> describePolicyAsync(DescribePolicyRequest request) {

        return describePolicyAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribePolicyResult> describePolicyAsync(final DescribePolicyRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribePolicyRequest, DescribePolicyResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DescribePolicyResult>() {
            @Override
            public DescribePolicyResult call() throws Exception {
                DescribePolicyResult result;

                try {
                    result = describePolicy(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DetachPolicyResult> detachPolicyAsync(DetachPolicyRequest request) {

        return detachPolicyAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DetachPolicyResult> detachPolicyAsync(final DetachPolicyRequest request,
            final com.amazonaws.handlers.AsyncHandler<DetachPolicyRequest, DetachPolicyResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DetachPolicyResult>() {
            @Override
            public DetachPolicyResult call() throws Exception {
                DetachPolicyResult result;

                try {
                    result = detachPolicy(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<DisablePolicyTypeResult> disablePolicyTypeAsync(DisablePolicyTypeRequest request) {

        return disablePolicyTypeAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DisablePolicyTypeResult> disablePolicyTypeAsync(final DisablePolicyTypeRequest request,
            final com.amazonaws.handlers.AsyncHandler<DisablePolicyTypeRequest, DisablePolicyTypeResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<DisablePolicyTypeResult>() {
            @Override
            public DisablePolicyTypeResult call() throws Exception {
                DisablePolicyTypeResult result;

                try {
                    result = disablePolicyType(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<EnableFullControlResult> enableFullControlAsync(EnableFullControlRequest request) {

        return enableFullControlAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<EnableFullControlResult> enableFullControlAsync(final EnableFullControlRequest request,
            final com.amazonaws.handlers.AsyncHandler<EnableFullControlRequest, EnableFullControlResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<EnableFullControlResult>() {
            @Override
            public EnableFullControlResult call() throws Exception {
                EnableFullControlResult result;

                try {
                    result = enableFullControl(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<EnablePolicyTypeResult> enablePolicyTypeAsync(EnablePolicyTypeRequest request) {

        return enablePolicyTypeAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<EnablePolicyTypeResult> enablePolicyTypeAsync(final EnablePolicyTypeRequest request,
            final com.amazonaws.handlers.AsyncHandler<EnablePolicyTypeRequest, EnablePolicyTypeResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<EnablePolicyTypeResult>() {
            @Override
            public EnablePolicyTypeResult call() throws Exception {
                EnablePolicyTypeResult result;

                try {
                    result = enablePolicyType(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<InviteAccountToOrganizationResult> inviteAccountToOrganizationAsync(InviteAccountToOrganizationRequest request) {

        return inviteAccountToOrganizationAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<InviteAccountToOrganizationResult> inviteAccountToOrganizationAsync(final InviteAccountToOrganizationRequest request,
            final com.amazonaws.handlers.AsyncHandler<InviteAccountToOrganizationRequest, InviteAccountToOrganizationResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<InviteAccountToOrganizationResult>() {
            @Override
            public InviteAccountToOrganizationResult call() throws Exception {
                InviteAccountToOrganizationResult result;

                try {
                    result = inviteAccountToOrganization(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<LeaveOrganizationResult> leaveOrganizationAsync(LeaveOrganizationRequest request) {

        return leaveOrganizationAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<LeaveOrganizationResult> leaveOrganizationAsync(final LeaveOrganizationRequest request,
            final com.amazonaws.handlers.AsyncHandler<LeaveOrganizationRequest, LeaveOrganizationResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<LeaveOrganizationResult>() {
            @Override
            public LeaveOrganizationResult call() throws Exception {
                LeaveOrganizationResult result;

                try {
                    result = leaveOrganization(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListAccountsResult> listAccountsAsync(ListAccountsRequest request) {

        return listAccountsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListAccountsResult> listAccountsAsync(final ListAccountsRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListAccountsRequest, ListAccountsResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListAccountsResult>() {
            @Override
            public ListAccountsResult call() throws Exception {
                ListAccountsResult result;

                try {
                    result = listAccounts(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListAccountsForParentResult> listAccountsForParentAsync(ListAccountsForParentRequest request) {

        return listAccountsForParentAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListAccountsForParentResult> listAccountsForParentAsync(final ListAccountsForParentRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListAccountsForParentRequest, ListAccountsForParentResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListAccountsForParentResult>() {
            @Override
            public ListAccountsForParentResult call() throws Exception {
                ListAccountsForParentResult result;

                try {
                    result = listAccountsForParent(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListChildrenResult> listChildrenAsync(ListChildrenRequest request) {

        return listChildrenAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListChildrenResult> listChildrenAsync(final ListChildrenRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListChildrenRequest, ListChildrenResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListChildrenResult>() {
            @Override
            public ListChildrenResult call() throws Exception {
                ListChildrenResult result;

                try {
                    result = listChildren(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListCreateAccountStatusResult> listCreateAccountStatusAsync(ListCreateAccountStatusRequest request) {

        return listCreateAccountStatusAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListCreateAccountStatusResult> listCreateAccountStatusAsync(final ListCreateAccountStatusRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListCreateAccountStatusRequest, ListCreateAccountStatusResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListCreateAccountStatusResult>() {
            @Override
            public ListCreateAccountStatusResult call() throws Exception {
                ListCreateAccountStatusResult result;

                try {
                    result = listCreateAccountStatus(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListHandshakesForAccountResult> listHandshakesForAccountAsync(ListHandshakesForAccountRequest request) {

        return listHandshakesForAccountAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListHandshakesForAccountResult> listHandshakesForAccountAsync(final ListHandshakesForAccountRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListHandshakesForAccountRequest, ListHandshakesForAccountResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListHandshakesForAccountResult>() {
            @Override
            public ListHandshakesForAccountResult call() throws Exception {
                ListHandshakesForAccountResult result;

                try {
                    result = listHandshakesForAccount(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListHandshakesForOrganizationResult> listHandshakesForOrganizationAsync(ListHandshakesForOrganizationRequest request) {

        return listHandshakesForOrganizationAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListHandshakesForOrganizationResult> listHandshakesForOrganizationAsync(
            final ListHandshakesForOrganizationRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListHandshakesForOrganizationRequest, ListHandshakesForOrganizationResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListHandshakesForOrganizationResult>() {
            @Override
            public ListHandshakesForOrganizationResult call() throws Exception {
                ListHandshakesForOrganizationResult result;

                try {
                    result = listHandshakesForOrganization(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListOrganizationalUnitsForParentResult> listOrganizationalUnitsForParentAsync(
            ListOrganizationalUnitsForParentRequest request) {

        return listOrganizationalUnitsForParentAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListOrganizationalUnitsForParentResult> listOrganizationalUnitsForParentAsync(
            final ListOrganizationalUnitsForParentRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListOrganizationalUnitsForParentRequest, ListOrganizationalUnitsForParentResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListOrganizationalUnitsForParentResult>() {
            @Override
            public ListOrganizationalUnitsForParentResult call() throws Exception {
                ListOrganizationalUnitsForParentResult result;

                try {
                    result = listOrganizationalUnitsForParent(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListParentsResult> listParentsAsync(ListParentsRequest request) {

        return listParentsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListParentsResult> listParentsAsync(final ListParentsRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListParentsRequest, ListParentsResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListParentsResult>() {
            @Override
            public ListParentsResult call() throws Exception {
                ListParentsResult result;

                try {
                    result = listParents(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListPoliciesResult> listPoliciesAsync(ListPoliciesRequest request) {

        return listPoliciesAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListPoliciesResult> listPoliciesAsync(final ListPoliciesRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListPoliciesRequest, ListPoliciesResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListPoliciesResult>() {
            @Override
            public ListPoliciesResult call() throws Exception {
                ListPoliciesResult result;

                try {
                    result = listPolicies(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListPoliciesForTargetResult> listPoliciesForTargetAsync(ListPoliciesForTargetRequest request) {

        return listPoliciesForTargetAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListPoliciesForTargetResult> listPoliciesForTargetAsync(final ListPoliciesForTargetRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListPoliciesForTargetRequest, ListPoliciesForTargetResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListPoliciesForTargetResult>() {
            @Override
            public ListPoliciesForTargetResult call() throws Exception {
                ListPoliciesForTargetResult result;

                try {
                    result = listPoliciesForTarget(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListRootsResult> listRootsAsync(ListRootsRequest request) {

        return listRootsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListRootsResult> listRootsAsync(final ListRootsRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListRootsRequest, ListRootsResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListRootsResult>() {
            @Override
            public ListRootsResult call() throws Exception {
                ListRootsResult result;

                try {
                    result = listRoots(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<ListTargetsForPolicyResult> listTargetsForPolicyAsync(ListTargetsForPolicyRequest request) {

        return listTargetsForPolicyAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListTargetsForPolicyResult> listTargetsForPolicyAsync(final ListTargetsForPolicyRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListTargetsForPolicyRequest, ListTargetsForPolicyResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<ListTargetsForPolicyResult>() {
            @Override
            public ListTargetsForPolicyResult call() throws Exception {
                ListTargetsForPolicyResult result;

                try {
                    result = listTargetsForPolicy(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<MoveAccountResult> moveAccountAsync(MoveAccountRequest request) {

        return moveAccountAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<MoveAccountResult> moveAccountAsync(final MoveAccountRequest request,
            final com.amazonaws.handlers.AsyncHandler<MoveAccountRequest, MoveAccountResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<MoveAccountResult>() {
            @Override
            public MoveAccountResult call() throws Exception {
                MoveAccountResult result;

                try {
                    result = moveAccount(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<RemoveAccountFromOrganizationResult> removeAccountFromOrganizationAsync(RemoveAccountFromOrganizationRequest request) {

        return removeAccountFromOrganizationAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<RemoveAccountFromOrganizationResult> removeAccountFromOrganizationAsync(
            final RemoveAccountFromOrganizationRequest request,
            final com.amazonaws.handlers.AsyncHandler<RemoveAccountFromOrganizationRequest, RemoveAccountFromOrganizationResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<RemoveAccountFromOrganizationResult>() {
            @Override
            public RemoveAccountFromOrganizationResult call() throws Exception {
                RemoveAccountFromOrganizationResult result;

                try {
                    result = removeAccountFromOrganization(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<UpdateOrganizationalUnitResult> updateOrganizationalUnitAsync(UpdateOrganizationalUnitRequest request) {

        return updateOrganizationalUnitAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<UpdateOrganizationalUnitResult> updateOrganizationalUnitAsync(final UpdateOrganizationalUnitRequest request,
            final com.amazonaws.handlers.AsyncHandler<UpdateOrganizationalUnitRequest, UpdateOrganizationalUnitResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<UpdateOrganizationalUnitResult>() {
            @Override
            public UpdateOrganizationalUnitResult call() throws Exception {
                UpdateOrganizationalUnitResult result;

                try {
                    result = updateOrganizationalUnit(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    @Override
    public java.util.concurrent.Future<UpdatePolicyResult> updatePolicyAsync(UpdatePolicyRequest request) {

        return updatePolicyAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<UpdatePolicyResult> updatePolicyAsync(final UpdatePolicyRequest request,
            final com.amazonaws.handlers.AsyncHandler<UpdatePolicyRequest, UpdatePolicyResult> asyncHandler) {

        return executorService.submit(new java.util.concurrent.Callable<UpdatePolicyResult>() {
            @Override
            public UpdatePolicyResult call() throws Exception {
                UpdatePolicyResult result;

                try {
                    result = updatePolicy(request);
                } catch (Exception ex) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(ex);
                    }
                    throw ex;
                }

                if (asyncHandler != null) {
                    asyncHandler.onSuccess(request, result);
                }
                return result;
            }
        });
    }

    /**
     * Shuts down the client, releasing all managed resources. This includes forcibly terminating all pending
     * asynchronous service calls. Clients who wish to give pending asynchronous service calls time to complete should
     * call {@code getExecutorService().shutdown()} followed by {@code getExecutorService().awaitTermination()} prior to
     * calling this method.
     */
    @Override
    public void shutdown() {
        super.shutdown();
        executorService.shutdownNow();
    }
}
