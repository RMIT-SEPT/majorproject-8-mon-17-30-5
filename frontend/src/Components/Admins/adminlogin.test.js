import React from 'react';
import AdminLogin from './AdminLogin';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render admin login correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<AdminLogin/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(5);
});