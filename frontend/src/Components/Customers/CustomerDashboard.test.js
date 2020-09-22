import React from 'react';
import CustomerDashboard from '../Customers/CustomerDashboard';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render customer dashboard correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<CustomerDashboard/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
});
